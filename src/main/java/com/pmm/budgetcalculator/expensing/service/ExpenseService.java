package com.pmm.budgetcalculator.expensing.service;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseDto;
import com.pmm.budgetcalculator.expensing.entity.mapper.ExpenseMapper;
import com.pmm.budgetcalculator.expensing.exeption.ExpenseNotFoundException;
import com.pmm.budgetcalculator.expensing.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public List<ExpenseDto> getAllExpenses() {
        return expenseRepository.
                findAll().
                stream().map(expense -> expenseMapper.entityToDto(expense)).collect(Collectors.toList());
    }

    public ExpenseDto getExpenseById(Long id) {
        return expenseRepository.findById(id).
                map(expense -> expenseMapper.entityToDto(expense))
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    public Expense createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.dtoToEntity(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        ExpenseDto dto = expenseMapper.entityToDto(savedExpense);
        return expenseRepository.save(expense);
    }

    public void removeExpenseById(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else throw new ExpenseNotFoundException(id);
    }

    public Expense updateExpense(Long id, ExpenseDto expenseDetailsDto) {
        if (expenseRepository.existsById(id)) {
            Expense expense = expenseMapper.dtoToEntity(expenseDetailsDto);
            Expense updateExpense = expenseRepository.getExpenseById(id);
            updateExpense.setExpenseAmount(expenseDetailsDto.getExpenseAmount());
            updateExpense.setExpensePlace(expenseDetailsDto.getExpensePlace());
            updateExpense.setExpenseName(expenseDetailsDto.getExpenseName());
            updateExpense.setExpenseDescription(expenseDetailsDto.getExpenseDescription());
            updateExpense.setExpenseTime(expenseDetailsDto.getExpenseTime());
            ExpenseDto expenseDetails = expenseMapper.entityToDto(expense);
            return expenseRepository.save(expense);
        } else throw new ExpenseNotFoundException(id);
    }
}
