package com.example.marcosmtz.littlepig.InfoToSave;

/**
 * Created by marcosmtz on 08/12/16.
 */

public class GoalsInfo {
    public String GoalName;
    public double GoalValue;
    public double GoalTime;

    public GoalsInfo() {
    }

    public void setGoalName(String goalName) {
        GoalName = goalName;
    }

    public void setGoalValue(double goalValue) {
        GoalValue = goalValue;
    }

    public void setGoalTime(double goalTime) {
        GoalTime = goalTime;
    }


    public String getGoalName() {
        return GoalName;
    }

    public double getGoalValue() {
        return GoalValue;
    }

    public double getGoalTime() {
        return GoalTime;
    }


    public GoalsInfo(String goalName, double goalValue, double goalTime) {
        GoalName = goalName;
        GoalValue = goalValue;
        GoalTime = goalTime;
    }


}