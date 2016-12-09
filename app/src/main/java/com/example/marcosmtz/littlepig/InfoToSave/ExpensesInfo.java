package com.example.marcosmtz.littlepig.InfoToSave;

/**
 * Created by marcosmtz on 08/12/16.
 */

public class ExpensesInfo {
    public String expenseName;
    public double expenseValue;
    public String expenseDescription;
    public boolean fixedExpense;

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setExpenseValue(double expenseValue) {
        this.expenseValue = expenseValue;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public void setFixedExpense(boolean fixedExpense) {
        this.fixedExpense = fixedExpense;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public double getExpenseValue() {
        return expenseValue;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public boolean isFixedExpense() {
        return fixedExpense;
    }

    public ExpensesInfo(String expenseName, double expenseValue, String expenseDescription, boolean fixedExpense) {
        this.expenseName = expenseName;
        this.expenseValue = expenseValue;
        this.expenseDescription = expenseDescription;
        this.fixedExpense = fixedExpense;
    }

    public ExpensesInfo() {
    }


}
