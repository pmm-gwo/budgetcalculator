package com.pmm.budgetcalculator.expensing.services;

import com.pmm.budgetcalculator.expensing.repositories.Expense;
import com.pmm.budgetcalculator.expensing.repositories.ExpenseType;
import com.pmm.budgetcalculator.expensing.repositories.ExpenseTypeRepository;
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

    public ExpenseType createExpenseType(ExpenseType expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    public void removeExpenseTypeById(Long id) {
        expenseTypeRepository.deleteById(id);
    }

//    public List<ExpenseType> findByCriteria(String expenseType) {
//        if (Objects.nonNull(expenseType)) {
//            return expenseTypeRepository.findByCriteria(expenseType);
//        }
//        return expenseTypeRepository.findAll();
//    }
}
