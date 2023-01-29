package com.pmm.budgetcalculator.expensing.entity.mapper;

import com.pmm.budgetcalculator.expensing.entity.Expense;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    Expense dtoToEntity(ExpenseDto expenseDto);

    ExpenseDto entityToDto(Expense expense);


    List<ExpenseDto> entityListToDtoList(List<Expense> expenseList);

    List<Expense> dtoListToEntityList(List<ExpenseDto> expenseDtoList);
}
