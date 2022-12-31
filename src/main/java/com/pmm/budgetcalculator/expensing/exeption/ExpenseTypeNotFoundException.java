package com.pmm.budgetcalculator.expensing.exeption;

public class ExpenseTypeNotFoundException extends RuntimeException {
    public ExpenseTypeNotFoundException(Long id) {
        super("ExpenseType on id " + id + " doesn't exist.");
    }
}
