package com.pmm.budgetcalculator.expensing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    List<Expense> findAll();
    List<Expense> findAllById(Long id);
    Optional<Expense> findById(Long id);
}
