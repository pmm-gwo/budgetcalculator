package com.pmm.budgetcalculator.expensing.controller;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Expense> removeExpenseById(@PathVariable("id") Long id) {
        expenseService.removeExpenseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody Expense expenseDetails) {
        Expense updateExpense = expenseService.getExpenseById(id);
        updateExpense.setExpenseAmount(expenseDetails.getExpenseAmount());
        updateExpense.setExpensePlace(expenseDetails.getExpensePlace());
        updateExpense.setExpenseTypes(expenseDetails.getExpenseTypes());
        updateExpense.setExpenseName(expenseDetails.getExpenseName());
        updateExpense.setExpenseDescription(expenseDetails.getExpenseDescription());
        updateExpense.setExpenseTime(expenseDetails.getExpenseTime());
        expenseService.createExpense(updateExpense);
        return ResponseEntity.ok(updateExpense);
    }

}



