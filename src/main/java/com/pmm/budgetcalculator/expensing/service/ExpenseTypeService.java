package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseTypeDto;
import com.pmm.budgetcalculator.expensing.entity.mapper.ExpenseTypeMapper;
import com.pmm.budgetcalculator.expensing.exeption.ExpenseTypeNotFoundException;
import com.pmm.budgetcalculator.expensing.repository.ExpenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExpenseTypeService {


    private final ExpenseTypeRepository expenseTypeRepository;
    private final ExpenseTypeMapper expenseTypeMapper;

    public List<ExpenseTypeDto> getAllExpenseTypes() {
        List<ExpenseType> expenseTypeList = expenseTypeRepository.findAll();
        List<ExpenseTypeDto> expenseTypeDtoList = expenseTypeMapper.entityListToDtoList(expenseTypeList);
        return expenseTypeDtoList;
    }

    public ExpenseType getExpenseTypeById(Long id) {
        return expenseTypeRepository.findById(id).orElseThrow(() -> new ExpenseTypeNotFoundException(id));
    }

    public ExpenseType createExpenseType(ExpenseType expenseType) {
        return expenseTypeRepository.save(expenseType);
    }

    public void removeExpenseTypeById(Long id) {
        if (expenseTypeRepository.existsById(id)) {
            expenseTypeRepository.deleteById(id);
        } else throw new ExpenseTypeNotFoundException(id);
    }

    public ExpenseType updateExpenseType(Long id, ExpenseType expenseTypeDetails) {
        if (expenseTypeRepository.existsById(id)) {
            ExpenseType updateExpenseType = expenseTypeRepository.getExpenseTypeById(id);
            updateExpenseType.setExpenseTypeName(expenseTypeDetails.getExpenseTypeName());
            updateExpenseType.setExpense(expenseTypeDetails.getExpense());
            return expenseTypeRepository.save(expenseTypeDetails);
        } else throw new ExpenseTypeNotFoundException(id);
    }

    public List<ExpenseType> findByCriteria(String expenseTypeName) {
        if (Objects.nonNull(expenseTypeName)) {
            return expenseTypeRepository.findByExpenseTypeName(expenseTypeName);
        }
        return expenseTypeRepository.findAll();
    }

}

