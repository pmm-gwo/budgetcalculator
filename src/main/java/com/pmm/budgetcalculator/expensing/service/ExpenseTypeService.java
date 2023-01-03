package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.repository.ExpenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExpenseTypeService {


    private final ExpenseTypeRepository expenseTypeRepository;

    public List<ExpenseType> getAllExpenseTypes() {
        return expenseTypeRepository.findAll();
    }

    public ExpenseType getExpenseTypeById(Long id) {
        return expenseTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public ExpenseType createExpenseType(ExpenseType expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    public void removeExpenseTypeById(Long id) {
        if (expenseTypeRepository.existsById(id)) {
            expenseTypeRepository.deleteById(id);
        } else ResponseEntity.notFound().build();
    }

    public ResponseEntity<ExpenseType> updateExpenseType(Long id, ExpenseType expenseTypeDetails) {
        if (expenseTypeRepository.existsById(id)) {
            ExpenseType updateExpenseType = expenseTypeRepository.getExpenseTypeById(id);
            updateExpenseType.setExpenseTypeName(expenseTypeDetails.getExpenseTypeName());
            updateExpenseType.setExpense(expenseTypeDetails.getExpense());
            expenseTypeRepository.save(expenseTypeDetails);
            return ResponseEntity.ok(updateExpenseType);
        } else return ResponseEntity.notFound().build();
    }

    public List<ExpenseType> findByCriteria(String expenseTypeName) {
        if (Objects.nonNull(expenseTypeName)) {
            return expenseTypeRepository.findByExpenseTypeName(expenseTypeName);
        }
        return expenseTypeRepository.findAll();
    }

}

