package com.pmm.budgetcalculator.expensing.exeption;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(Long id) {
        super("Expense on id " + id + " doesn't exist.");
    }
}
