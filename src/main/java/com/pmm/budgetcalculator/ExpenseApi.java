package com.pmm.budgetcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseApi {


    private ExpenseManager expenseManager;

    @Autowired
    public ExpenseApi(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    @GetMapping("/getExpense")
    public List<Expense> getExpense() {
        return expenseManager.getExpenseList();
    }

    @PostMapping("/addExpense")
    public boolean Expense(@RequestBody Expense expense) {
        return expenseManager.addExpense(expense);
    }
}
