package com.pmm.budgetcalculator.expensing.entity.dto;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.ExpensePlan;
import lombok.Data;

import java.util.List;

@Data

public class ExpenseCategoryDTO {
    private String expenseCategoryName;
    private List<ExpensePlan> expensePlans;
    private List<Expense> expenses;
}

