package com.pmm.budgetcalculator.expensing.domain.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    List<Expense> findAllByExpenseId(Long id);

}
