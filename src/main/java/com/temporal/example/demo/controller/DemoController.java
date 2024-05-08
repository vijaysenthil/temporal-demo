package com.temporal.example.demo.controller;

import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import com.temporal.example.demo.temporal.workflow.TeamWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private WorkflowClient workflowClient;

    @PostMapping("/test")
    public ResponseEntity<String> test() {
        var id = "test-"+ UUID.randomUUID();
       log.info("creating workflow {}", id);
        var workflow =
                workflowClient.newWorkflowStub(
                        TeamWorkflow.class,
                        WorkflowOptions.newBuilder()
                                .setWorkflowId(id)
                                .setTaskQueue(TeamWorkflow.TASK_QUEUE)
                                .build());
        TeamWorkFlowRequest workflowRequest = TeamWorkFlowRequest.builder().test("testPayload").build();
        WorkflowClient.start(workflow::processTeamRequest, workflowRequest);
        return new ResponseEntity<>("demo", HttpStatus.OK);
    }
}
