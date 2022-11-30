package com.pmm.budgetcalculator.expensing.domain.expense;

import com.pmm.budgetcalculator.foundation.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Expense extends BaseEntity {

    private String expenseName;
    private String expenseDescription;
    private String expenseTime;
    private BigDecimal expenseAmount;
    private String expensePlace;


    public Expense(String expenseTime) {
        this.expenseTime = "dd-MM-yyyy";
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


    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpensePlace() {
        return expensePlace;
    }

    public void setExpensePlace(String expensePlace) {
        this.expensePlace = expensePlace;
    }

    public String getExpenseTime() {
        return expenseTime;
    }

    public void setExpenseTime(String expenseTime) {
        this.expenseTime = expenseTime;

    }
}
