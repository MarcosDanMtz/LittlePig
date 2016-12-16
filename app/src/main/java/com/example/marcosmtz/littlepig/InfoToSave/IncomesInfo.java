package com.example.marcosmtz.littlepig.InfoToSave;

/**
 * Created by marcosmtz on 07/12/16.
 */

public class IncomesInfo {
    public String incomeName;
    public float incomeValue;
    public String incomeDescription;
    public boolean fixedIncome;

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public void setIncomeValue(float incomeValue) {
        this.incomeValue = incomeValue;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public void setFixedIncome(boolean fixedIncome) {
        this.fixedIncome = fixedIncome;
    }

    public String getIncomeName() {
        return incomeName;
    }

    public float getIncomeValue() {
        return incomeValue;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public boolean isFixedIncome() {
        return fixedIncome;
    }

    public IncomesInfo(String incomeName, float incomeValue, String incomeDescription, boolean fixedIncome) {
        this.incomeName = incomeName;
        this.incomeValue = incomeValue;
        this.incomeDescription = incomeDescription;
        this.fixedIncome = fixedIncome;
    }

    public IncomesInfo() {
    }
}
