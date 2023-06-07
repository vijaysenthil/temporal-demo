package com.temporal.example.demo.temporal.activity.team;


import com.temporal.example.demo.temporal.model.TeamWorkFlowRequest;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface FMVFActivity {
  void doActivity(TeamWorkFlowRequest request);
}
