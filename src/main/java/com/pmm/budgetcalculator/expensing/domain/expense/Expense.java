package com.pmm.budgetcalculator.expensing.domain.expense;

import com.pmm.budgetcalculator.foundation.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity

public class Expense extends BaseEntity {
    long expenseId;
    String expenseName;
    String expenseDescription;
    LocalDateTime expenseTime;
    double expenseAmount; //or BigDecimal
    String expensePlace;


    public Expense() {
        this.expenseTime = LocalDateTime.now();
    }


    public Expense(String expenseName, String expenseDescription, LocalDateTime expenseTime, double expenseAmount, String expensePlace, long expenseId) {
        this.expenseName = expenseName;
        this.expenseDescription = expenseDescription;
        this.expenseTime = expenseTime;
        this.expenseAmount = expenseAmount;
        this.expensePlace = expensePlace;
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public LocalDateTime getExpenseTime() {
        return expenseTime;
    }

    public void setExpenseTime(LocalDateTime expenseTime) {
        this.expenseTime = expenseTime;
    }

    public String getExpensePlace() {
        return expensePlace;
    }

    public void setExpensePlace(String expensePlace) {
        this.expensePlace = expensePlace;
    }

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenseId) {
        this.expenseId = expenseId;
    }
}
