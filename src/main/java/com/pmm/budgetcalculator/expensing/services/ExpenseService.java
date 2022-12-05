package com.pmm.budgetcalculator.expensing.services;

import com.pmm.budgetcalculator.expensing.repositories.Expense;
import com.pmm.budgetcalculator.expensing.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found for Id:" + id));
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void removeExpenseById(Long id) {
        expenseRepository.deleteById(id);}

}






