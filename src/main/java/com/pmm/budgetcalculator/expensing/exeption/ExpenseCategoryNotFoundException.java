package com.pmm.budgetcalculator.expensing.exeption;

public class ExpenseCategoryNotFoundException extends RuntimeException {
    public ExpenseCategoryNotFoundException(Long id) {
        super("Expense on id " + id + " doesn't exist.");
    }
}

