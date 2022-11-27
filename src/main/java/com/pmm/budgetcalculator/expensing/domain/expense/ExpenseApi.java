package com.pmm.budgetcalculator.expensing.domain.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseApi {


    private ExpenseService expenseService;

    @Autowired
    public ExpenseApi(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/sayHello")
    public String main(@RequestParam String name) {
        return "Hello" + name;
    }

    @GetMapping("/getExpense")
    public List<Expense> getExpense() {
        return expenseService.getExpenseList();
    }

    @PostMapping("/addExpense")
    public boolean Expense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }
}
