package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseCategoryDto;
import com.pmm.budgetcalculator.expensing.entity.mapper.ExpenseCategoryMapper;
import com.pmm.budgetcalculator.expensing.exeption.EntityNotFoundException;
import com.pmm.budgetcalculator.expensing.repository.ExpenseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryService {
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseCategoryMapper expenseCategoryMapper;

    public List<ExpenseCategoryDto> getAllExpenseCategories() {

        return expenseCategoryRepository.findAll().
                stream().
                map(expenseCategory -> expenseCategoryMapper.entityToDto(expenseCategory)).
                collect(Collectors.toList());
    }

    public ExpenseCategoryDto getExpenseCategoryById(Long id) {
        return expenseCategoryRepository.findById(id).
                map(expenseCategory -> expenseCategoryMapper.entityToDto(expenseCategory))
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    public ExpenseCategoryDto createExpenseCategory(ExpenseCategoryDto expenseCategoryDto) {
        ExpenseCategory expenseCategory = expenseCategoryMapper.dtoToEntity(expenseCategoryDto);
        ExpenseCategory savedExpenseCategory = expenseCategoryRepository.save(expenseCategory);
        return expenseCategoryMapper.entityToDto(savedExpenseCategory);
    }

    public void removeExpenseCategoryById(Long id) {
        if (expenseCategoryRepository.existsById(id)) {
            expenseCategoryRepository.deleteById(id);
        } else throw new EntityNotFoundException(id);
    }

    public ExpenseCategory updateExpenseCategory(Long id, ExpenseCategoryDto expenseCategoryDetailsDto) {
        if (expenseCategoryRepository.existsById(id)) {
            ExpenseCategory expenseCategory = expenseCategoryMapper.dtoToEntity(expenseCategoryDetailsDto);
            ExpenseCategory updateExpenseCategory = expenseCategoryRepository.getExpenseCategoryById(id);
            updateExpenseCategory.setExpenseCategoryName(expenseCategoryDetailsDto.getExpenseCategoryName());
            ExpenseCategoryDto expenseCategoryDetails = expenseCategoryMapper.entityToDto(expenseCategory);
            return expenseCategoryRepository.save(expenseCategory);
        } else throw new EntityNotFoundException(id);
    }
}
