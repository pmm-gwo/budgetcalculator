package com.pmm.budgetcalculator.expensing.domain.expense;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

//    public List<Expense> getAllExpenses() {
//        return expenseRepository.findAll();
//    }

//    public List<Expense> getAllById(Long id) {
//        return expenseRepository.findAllById(id);
//    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found for Id:" + id));
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void removeExpenseById(Long id) {
        expenseRepository.deleteById(id);}

}






