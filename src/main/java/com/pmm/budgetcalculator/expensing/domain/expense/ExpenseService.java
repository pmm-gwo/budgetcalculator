package com.pmm.budgetcalculator.expensing.domain.expense;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService{

    private final ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    public List<Expense> getAllByExpenseId(Long expenseId) {
        return expenseRepository.findAllByExpenseId(expenseId);
    }
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    }






