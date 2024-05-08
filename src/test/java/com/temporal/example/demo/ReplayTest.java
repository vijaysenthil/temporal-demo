package com.temporal.example.demo;

import com.temporal.example.demo.temporal.workflow.TeamWorkflow;
import com.temporal.example.demo.temporal.workflow.TeamWorkflowImpl;
import io.temporal.testing.WorkflowReplayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ReplayTest {

    private ClassLoader classLoader;

    @BeforeEach
    public void setup() {
        classLoader = getClass().getClassLoader();
    }

    @Test
    public void replayTest(){
        File eventHistoryFile =
                new File(
                        Objects.requireNonNull(
                                        classLoader.getResource("team_workflow_event.json"))
                                .getFile());
        assertDoesNotThrow(
                () -> WorkflowReplayer.replayWorkflowExecution(eventHistoryFile, TeamWorkflowImpl.class));

    }
}
