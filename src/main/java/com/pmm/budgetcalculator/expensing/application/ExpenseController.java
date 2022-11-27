package com.pmm.budgetcalculator.expensing.application;

import com.pmm.budgetcalculator.expensing.domain.expense.ExpenseRepository;
import com.pmm.budgetcalculator.expensing.domain.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    ExpenseRepository expenseRepository;

}
