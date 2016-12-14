package com.example.marcosmtz.littlepig.InfoToSave;

/**
 * Created by marcosmtz on 07/12/16.
 */

public class IncomesInfo {
    public String IncomeName;
    public double IncomeValue;
    public String IncomeDescription;
    public boolean FixedIncome;

    public void setIncomeName(String incomeName) {
        IncomeName = incomeName;
    }

    public void setIncomeValue(Double incomeValue) {
        IncomeValue = incomeValue;
    }

    public void setIncomeDescription(String incomeDescription) {
        IncomeDescription = incomeDescription;
    }

    public void setFixedIncome(Boolean fixedIncome) {
        FixedIncome = fixedIncome;
    }

    public String getIncomeName() {
        return IncomeName;
    }

    public Double getIncomeValue() {
        return IncomeValue;
    }

    public String getIncomeDescription() {
        return IncomeDescription;
    }

    public Boolean getFixedIncome() {
        return FixedIncome;
    }

    public IncomesInfo(String incomeName, double incomeValue, String incomeDescription, Boolean fixedIncome) {
        IncomeName = incomeName;
        IncomeValue = incomeValue;
        IncomeDescription = incomeDescription;
        FixedIncome = fixedIncome;
    }

    public IncomesInfo() {
    }
}
