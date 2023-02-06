package com.pmm.budgetcalculator.expensing.exeption;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("Entity on id " + id + " doesn't exist.");
    }
}
