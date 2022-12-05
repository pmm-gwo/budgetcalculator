package com.pmm.budgetcalculator.expensing.controllers;

import com.pmm.budgetcalculator.expensing.repositories.Expense;
import com.pmm.budgetcalculator.expensing.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getOneExpense(@PathVariable("id") Long id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.createExpense(expense));
    }

    @DeleteMapping("/{id}")
    public void removeExpense(@PathVariable("id") Long id) {
        expenseService.removeExpenseById(id);
    }

}
