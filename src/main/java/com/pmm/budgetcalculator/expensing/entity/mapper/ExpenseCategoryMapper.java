package com.pmm.budgetcalculator.expensing.entity.mapper;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseCategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ExpenseCategoryMapper  {

    ExpenseCategory dtoToEntity(ExpenseCategoryDto expenseCategoryDto);

    ExpenseCategoryDto entityToDto(ExpenseCategory expenseCategory);

}
