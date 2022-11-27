package com.pmm.budgetcalculator.expensing.application;

import com.pmm.budgetcalculator.expensing.domain.expense.Expense;
import com.pmm.budgetcalculator.expensing.domain.expense.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

//    @Autowired
//    ExpenseService expenseService;
//
//    @Autowired
//    ExpenseRepository expenseRepository;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam(value = "branchId", required = false) Long expenseId) {
        if (Objects.nonNull(expenseId)) {
            return ResponseEntity.ok(expenseService.getAllByExpenseId(expenseId));
        }
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.createExpense(expense));
    }

}
