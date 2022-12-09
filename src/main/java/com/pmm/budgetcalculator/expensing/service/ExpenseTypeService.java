package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.repository.ExpenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
