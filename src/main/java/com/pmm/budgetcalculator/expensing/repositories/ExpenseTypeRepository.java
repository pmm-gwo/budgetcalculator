package com.pmm.budgetcalculator.expensing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {
    List<ExpenseType>findAll();
    List<ExpenseType> findAllById(Long id);
    Optional<ExpenseType> findById(Long id);
//    @Query(value = "select * from expenseType c where :expenseType = null or c.expenseType = expenseType")
//    List<ExpenseType> findByCriteria(@Param("expenseType") String expenseType);

}
