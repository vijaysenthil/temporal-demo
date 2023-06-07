package com.temporal.example.demo.temporal.model;

import java.io.Serializable;

public class TeamWorkFlowRequest implements Serializable {
  private String test;

  public TeamWorkFlowRequest(String test) {
    this.test = test;
  }

  public TeamWorkFlowRequest() {
  }

  public static TeamWorkFlowRequestBuilder builder() {
    return new TeamWorkFlowRequestBuilder();
  }

  public String getTest() {
    return this.test;
  }

  public void setTest(String test) {
    this.test = test;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof TeamWorkFlowRequest)) return false;
    final TeamWorkFlowRequest other = (TeamWorkFlowRequest) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$test = this.getTest();
    final Object other$test = other.getTest();
    if (this$test == null ? other$test != null : !this$test.equals(other$test)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof TeamWorkFlowRequest;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $test = this.getTest();
    result = result * PRIME + ($test == null ? 43 : $test.hashCode());
    return result;
  }

  public String toString() {
    return "TeamWorkFlowRequest(test=" + this.getTest() + ")";
  }

  public static class TeamWorkFlowRequestBuilder {
    private String test;

    TeamWorkFlowRequestBuilder() {
    }

    public TeamWorkFlowRequestBuilder test(String test) {
      this.test = test;
      return this;
    }

    public TeamWorkFlowRequest build() {
      return new TeamWorkFlowRequest(test);
    }

    public String toString() {
      return "TeamWorkFlowRequest.TeamWorkFlowRequestBuilder(test=" + this.test + ")";
    }
  }
}
