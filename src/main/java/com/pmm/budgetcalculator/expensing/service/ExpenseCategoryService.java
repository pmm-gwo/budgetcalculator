package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseCategoryDto;
import com.pmm.budgetcalculator.expensing.entity.mapper.ExpenseCategoryMapper;
import com.pmm.budgetcalculator.expensing.exeption.ExpenseCategoryNotFoundException;
import com.pmm.budgetcalculator.expensing.repository.ExpenseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
                .orElseThrow(() -> new ExpenseCategoryNotFoundException(id));
    }

    public ExpenseCategory createExpenseCategory(ExpenseCategory expenseCategory) {
        return expenseCategoryRepository.save(expenseCategory);
    }

    public void removeExpenseCategoryById(Long id) {
        if (expenseCategoryRepository.existsById(id)) {
            expenseCategoryRepository.deleteById(id);
        } else throw new ExpenseCategoryNotFoundException(id);
    }
    public List<ExpenseCategory> findByCriteria(String expenseCategoryName) {
        if (Objects.nonNull(expenseCategoryName)) {
            return expenseCategoryRepository.findByExpenseCategoryName(expenseCategoryName);
        }
        return expenseCategoryRepository.findAll();
    }


    public ExpenseCategory updateExpenseCategory(Long id, ExpenseCategory expenseCategoryDetails) {
        if (expenseCategoryRepository.existsById(id)) {
            ExpenseCategory updateExpenseCategory = expenseCategoryRepository.getExpenseCategoryById(id);
            updateExpenseCategory.setExpenseCategoryName(expenseCategoryDetails.getExpenseCategoryName());
            updateExpenseCategory.setExpensePlans(expenseCategoryDetails.getExpensePlans());
            updateExpenseCategory.setExpenses(expenseCategoryDetails.getExpenses());
            return expenseCategoryRepository.save(expenseCategoryDetails);
        } else throw new ExpenseCategoryNotFoundException(id);
    }
}
