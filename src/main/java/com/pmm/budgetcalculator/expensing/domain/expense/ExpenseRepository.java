package com.pmm.budgetcalculator.expensing.domain.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    List<Expense> findAllById(Long id);
    List<Expense> findAll(Long id);

}
