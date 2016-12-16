package com.example.marcosmtz.littlepig.InfoToSave;

/**
 * Created by marcosmtz on 08/12/16.
 */

public class GoalsInfo {
    public String goalName;
    public float goalValue;
    public float goalTime;

    public GoalsInfo() {
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public void setGoalValue(float goalValue) {
        this.goalValue = goalValue;
    }

    public void setGoalTime(float goalTime) {
        this.goalTime = goalTime;
    }

    public String getGoalName() {
        return goalName;
    }

    public float getGoalValue() {
        return goalValue;
    }

    public float getGoalTime() {
        return goalTime;
    }

    public GoalsInfo(String goalName, float goalValue, float goalTime) {
        this.goalName = goalName;
        this.goalValue = goalValue;
        this.goalTime = goalTime;
    }







}