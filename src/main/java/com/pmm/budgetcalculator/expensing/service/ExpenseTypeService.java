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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseTypeService {


    private final ExpenseTypeRepository expenseTypeRepository;
    private final ExpenseTypeMapper expenseTypeMapper;

    public List<ExpenseTypeDto> getAllExpenseTypes() {
        return expenseTypeRepository.
                findAll().
                stream().
                map(expenseType -> expenseTypeMapper.entityToDto(expenseType)).
                collect(Collectors.toList());
    }

    public ExpenseTypeDto getExpenseTypeById(Long id) {
        return expenseTypeRepository.findById(id).
                map(expenseType -> expenseTypeMapper.entityToDto(expenseType)).
                orElseThrow(() -> new ExpenseTypeNotFoundException(id));
    }

    public ExpenseType createExpenseType(ExpenseTypeDto expenseTypeDto) {
        ExpenseType expenseType = expenseTypeMapper.dtoToEntity(expenseTypeDto);
        ExpenseType savedExpenseType = expenseTypeRepository.save(expenseType);
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

