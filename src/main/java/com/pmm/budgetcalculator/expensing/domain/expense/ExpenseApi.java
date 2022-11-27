package com.pmm.budgetcalculator.expensing.domain.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseApi {


    private ExpenseManager expenseManager;

    @Autowired
    public ExpenseApi(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    @GetMapping("/sayHello")
    public String main(@RequestParam String name) {
        return "Hello" + name;
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
