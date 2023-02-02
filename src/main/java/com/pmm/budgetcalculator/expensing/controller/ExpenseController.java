package com.pmm.budgetcalculator.expensing.controller;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseDto;
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
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getOneExpense(@PathVariable("id") Long id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        return ResponseEntity.ok(expenseService.createExpense(expenseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> removeExpenseById(@PathVariable("id") Long id) {
        expenseService.removeExpenseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Long id, @RequestBody ExpenseDto expenseDetailsDto) {
        return ResponseEntity.ok(expenseService.updateExpense(id, expenseDetailsDto));
    }

}



