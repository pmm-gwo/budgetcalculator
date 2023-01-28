package com.pmm.budgetcalculator.expensing.entity.dto;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import lombok.Data;

import java.util.List;

@Data

public class ExpenseCategoryDTO {
    private String expenseCategoryName;
    private List<Expense> expenses;
}

