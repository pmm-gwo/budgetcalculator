package com.pmm.budgetcalculator.expensing.domain.expense;

import com.pmm.budgetcalculator.foundation.AbstractFactory;
import org.springframework.stereotype.Component;

@Component
public class ExpenseFactory implements AbstractFactory<Expense> {

    @Override
    public Expense create() {
        return new Expense();
    }
}