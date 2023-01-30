package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseDto;
import com.pmm.budgetcalculator.expensing.entity.mapper.ExpenseMapper;
import com.pmm.budgetcalculator.expensing.exeption.ExpenseNotFoundException;
import com.pmm.budgetcalculator.expensing.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public List<ExpenseDto> getAllExpenses() {
        return expenseRepository.
                findAll().
                stream().map(expense -> expenseMapper.entityToDto(expense)).
                collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
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
            updateExpense.setExpenseCategory(expenseDetails.getExpenseCategory());
            return expenseRepository.save(expenseDetails);
        } else throw new ExpenseNotFoundException(id);
    }
}
