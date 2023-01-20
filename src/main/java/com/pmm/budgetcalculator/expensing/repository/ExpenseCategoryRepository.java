package com.pmm.budgetcalculator.expensing.repository;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {
    List<ExpenseCategory> findAll();

    Optional<ExpenseCategory> findById(Long id);

    ExpenseCategory getExpenseCategoryById(Long id);

    List<ExpenseCategory> findByExpenseCategoryName(String expenseCategoryName);

}