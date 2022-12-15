package com.pmm.budgetcalculator.expensing.controller;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
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


//    @GetMapping
//    public ResponseEntity<List<ExpenseType>> getMany(
//            @RequestParam(value = "expenseType", required = false) String expenseType) {
//        return ResponseEntity.ok(expenseTypeService.findByCriteria(expenseType));
//    }
    @GetMapping
    public ResponseEntity<List<ExpenseType>> getAllExpenseTypes() {
        return ResponseEntity.ok(expenseTypeService.getAllExpenseTypes());
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


}

