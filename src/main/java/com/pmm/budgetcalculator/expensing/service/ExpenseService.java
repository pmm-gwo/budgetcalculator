package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.exeption.ExpenseNotFoundException;
import com.pmm.budgetcalculator.expensing.repository.ExpenseRepository;
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
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void removeExpenseById(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else throw new ExpenseNotFoundException(id);
    }

    public Expense updateExpense(Long id, Expense expenseDetails) {
        if (expenseRepository.existsById(id)) {
            Expense updateExpense = expenseRepository.getExpenseById(id);
            updateExpense.setExpenseAmount(expenseDetails.getExpenseAmount());
            updateExpense.setExpensePlace(expenseDetails.getExpensePlace());
            updateExpense.setExpenseTypes(expenseDetails.getExpenseTypes());
            updateExpense.setExpenseName(expenseDetails.getExpenseName());
            updateExpense.setExpenseDescription(expenseDetails.getExpenseDescription());
            updateExpense.setExpenseTime(expenseDetails.getExpenseTime());
           return  expenseRepository.save(expenseDetails);

        } else throw new ExpenseNotFoundException(id);
    }
}
