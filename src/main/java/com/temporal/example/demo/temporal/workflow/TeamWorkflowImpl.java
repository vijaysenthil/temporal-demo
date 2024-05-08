package com.temporal.example.demo.temporal.workflow;


import com.temporal.example.demo.temporal.activity.team.FMVFActivity;
import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import io.temporal.activity.ActivityOptions;
import io.temporal.api.enums.v1.ParentClosePolicy;
import io.temporal.common.RetryOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.ChildWorkflowCancellationType;
import io.temporal.workflow.ChildWorkflowOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

@WorkflowImpl(taskQueues = "TeamTaskQueue")
public class TeamWorkflowImpl implements TeamWorkflow {
  private  Logger logger = Workflow.getLogger(this.getClass().getName());

  private  FMVFActivity fmvfActivity =
      Workflow.newActivityStub(
          FMVFActivity.class,
          ActivityOptions.newBuilder()
              .setRetryOptions(
                  RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(10)).build())
              .setStartToCloseTimeout(Duration.ofDays(1))
              .build());

  @Override
  public void processTeamRequest(TeamWorkFlowRequest request) {
    logger.info("Processing {} for Team {} as part of {}", request, request, request);
    fmvfActivity.doActivity(request);
    var workflowId = Workflow.getInfo().getWorkflowId();
    var childWorkflowOptions =
            ChildWorkflowOptions.newBuilder()
                    .setWorkflowId(workflowId+"-child")
                    .setWorkflowExecutionTimeout(Duration.ofDays(21))
                    .setParentClosePolicy(ParentClosePolicy.PARENT_CLOSE_POLICY_REQUEST_CANCEL)
                    .setCancellationType(ChildWorkflowCancellationType.WAIT_CANCELLATION_REQUESTED)
                    .build();
    var childWorkflow =
            Workflow.newChildWorkflowStub(ChildWorkflow.class, childWorkflowOptions);
    childWorkflow.process(request);

  }
}
