package com.pmm.budgetcalculator.expensing.controller;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseCategoryDto;
import com.pmm.budgetcalculator.expensing.service.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("expense_categories")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;

    @GetMapping
    public ResponseEntity<List<ExpenseCategoryDto>> getAllExpenseCategories() {
        return ResponseEntity.ok(expenseCategoryService.getAllExpenseCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategoryDto> getOneExpenseCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(expenseCategoryService.getExpenseCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<ExpenseCategoryDto> createExpenseCategory(@RequestBody ExpenseCategoryDto expenseCategoryDto) {
        return ResponseEntity.ok(expenseCategoryService.createExpenseCategory(expenseCategoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseCategory> removeExpenseCategoryById(@PathVariable("id") Long id) {
        expenseCategoryService.removeExpenseCategoryById(id);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseCategoryDto> updateExpenseCategory(@PathVariable("id") Long id, @RequestBody ExpenseCategoryDto expenseCategoryDetailsDto) {
        return ResponseEntity.ok(expenseCategoryService.updateExpenseCategory(id, expenseCategoryDetailsDto));
    }
}
