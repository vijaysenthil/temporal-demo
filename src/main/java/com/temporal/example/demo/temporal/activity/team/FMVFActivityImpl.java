package com.temporal.example.demo.temporal.activity.team;


import com.temporal.example.demo.controller.DemoController;
import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import io.temporal.spring.boot.ActivityImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@ActivityImpl(taskQueues = "TeamTaskQueue")
public class FMVFActivityImpl implements FMVFActivity {
  private static final Logger log = org.slf4j.LoggerFactory.getLogger(DemoController.class);
  @Override
  public void doActivity(TeamWorkFlowRequest request) {
    log.info("Team FMVF activity is mocked for team {}", request);
  }
}
