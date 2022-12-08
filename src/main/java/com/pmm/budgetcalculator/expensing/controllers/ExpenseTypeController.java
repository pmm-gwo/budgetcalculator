package com.pmm.budgetcalculator.expensing.controllers;

import com.pmm.budgetcalculator.expensing.repositories.ExpenseType;
import com.pmm.budgetcalculator.expensing.services.ExpenseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("expenses/expense_types")
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
    public void removeExpenseType(@PathVariable("id") Long id) {
        expenseTypeService.removeExpenseTypeById(id);
    }

}

