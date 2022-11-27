package com.pmm.budgetcalculator.expensing.domain.expense;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseManager {

    private List<Expense> expenseList;

    public ExpenseManager() {
        this.expenseList = new ArrayList<>();
        expenseList.add(new Expense("zakupy spozywcze", null, LocalDateTime.now(), 125.99, "Lidl", 1));
        expenseList.add(new Expense("paliwo", null, LocalDateTime.now(), 250, "Orlen", 2));
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }
    public boolean addExpense(Expense expense) {
        return expenseList.add(expense);
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }
}



