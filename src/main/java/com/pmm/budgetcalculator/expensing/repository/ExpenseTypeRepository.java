package com.pmm.budgetcalculator.expensing.repository;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {
    List<ExpenseType>findAll();
    List<ExpenseType> findAllById(Long id);
    Optional<ExpenseType> findById(Long id);

//    @Query(value = "select from expenseType where :expenseType = :expenseType", nativeQuery = true)
//    List<ExpenseType> findByExpenseType(@Param("expenseType") String expenseType);

}
