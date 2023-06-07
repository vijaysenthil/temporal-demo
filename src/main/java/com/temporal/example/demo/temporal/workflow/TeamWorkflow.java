package com.temporal.example.demo.temporal.workflow;

import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TeamWorkflow {
  public static final String TASK_QUEUE = "TeamTaskQueue";

  @WorkflowMethod
  void processTeamRequest(TeamWorkFlowRequest request);
}
