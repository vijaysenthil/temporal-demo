package com.temporal.example.demo.temporal.workflow;

import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ChildWorkflow {

  @WorkflowMethod
  void process(TeamWorkFlowRequest request);
}
