package com.temporal.example.demo.temporal.workflow;


import com.temporal.example.demo.temporal.activity.team.FMVFActivity;
import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;

import java.time.Duration;

@WorkflowImpl(taskQueues = "TeamTaskQueue")
public class ChildWorkflowImpl implements ChildWorkflow {
  private  Logger logger = Workflow.getLogger(this.getClass().getName());


  @Override
  public void process(TeamWorkFlowRequest request) {
    logger.info("Processing {} for Team {} as part of {}", request, request, request);
  }
}
