package com.pmm.budgetcalculator.expensing.controller;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseTypeDto;
import com.pmm.budgetcalculator.expensing.service.ExpenseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("expense_types")
public class ExpenseTypeController {
    private final ExpenseTypeService expenseTypeService;


    @GetMapping
    public ResponseEntity<List<ExpenseTypeDto>> getAllExpenseTypes() {
        return ResponseEntity.ok(expenseTypeService.getAllExpenseTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseTypeDto> getOneExpenseType(@PathVariable("id") Long id) {
        return ResponseEntity.ok(expenseTypeService.getExpenseTypeById(id));
    }

    @PostMapping
    public ResponseEntity<ExpenseType> createExpenseType(@RequestBody ExpenseType expenseType) {
        return ResponseEntity.ok(expenseTypeService.createExpenseType(expenseType));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseType> removeExpenseTypeById(@PathVariable("id") Long id) {
        expenseTypeService.removeExpenseTypeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseType> updateExpenseType(@PathVariable("id") Long id, @RequestBody ExpenseType expenseTypeDetails) {
        return ResponseEntity.ok(expenseTypeService.updateExpenseType(id, expenseTypeDetails));

    }

    @GetMapping("/name")
    public ResponseEntity<List<ExpenseType>> getManyExpenseTypes(
            @RequestParam(value = "expenseTypeName", required = false) String expenseTypeName) {
        return ResponseEntity.ok(expenseTypeService.findByCriteria(expenseTypeName));
    }
}

