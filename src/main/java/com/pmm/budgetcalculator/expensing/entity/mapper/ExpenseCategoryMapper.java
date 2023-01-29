package com.pmm.budgetcalculator.expensing.entity.mapper;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseCategoryDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ExpenseCategoryMapper  {

    ExpenseCategory dtoToEntity(ExpenseCategoryDto expenseCategoryDto);

    ExpenseCategoryDto entityToDto(Expense expense);

    List<ExpenseCategoryDto> entityListToDtoList(List<ExpenseCategory> expenseCategoryList);

    List<ExpenseCategory> dtoListToEntityList(List<ExpenseCategoryDto> expenseCategoryDtoList);
}
