package com.pmm.budgetcalculator.expensing.entity.mapper;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ExpenseMapper {

    Expense dtoToEntity(ExpenseDto expenseDto);

    ExpenseDto entityToDto(Expense expense);
}
