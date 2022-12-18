package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.repository.ExpenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseTypeService {


    private final ExpenseTypeRepository expenseTypeRepository;

    public List<ExpenseType> getAllExpenseTypes() {
        return expenseTypeRepository.findAll();
    }

    public ExpenseType getExpenseTypeById(Long id) {
        return expenseTypeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found for Id:" + id));
    }

    public ExpenseType createExpenseType(ExpenseType expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    public void removeExpenseTypeById(Long id) {
        if (expenseTypeRepository.existsById(id)) {
            expenseTypeRepository.deleteById(id);
        }
    }

    public ResponseEntity<ExpenseType> updateExpenseType(Long id, ExpenseType expenseTypeDetails) {
        if (expenseTypeRepository.existsById(id))
        {
            final ExpenseType updateExpenseType = expenseTypeRepository.save(expenseTypeDetails);
            return ResponseEntity.ok(updateExpenseType);
        }
        throw new RuntimeException("User not found on :: "+ id);
    }
//
//    public List<ExpenseType> findByCriteria(String expenseType) {
//        if (Objects.nonNull(expenseType)) {
//            return expenseTypeRepository.findByExpenseType(expenseType);
//        }
//        return expenseTypeRepository.findAll();
//    }

}

