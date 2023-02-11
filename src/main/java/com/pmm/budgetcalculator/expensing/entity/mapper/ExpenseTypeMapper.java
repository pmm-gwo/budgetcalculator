package com.pmm.budgetcalculator.expensing.entity.mapper;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ExpenseTypeMapper {

    ExpenseTypeDto entityToDto(ExpenseType expenseType);

    ExpenseType dtoToEntity(ExpenseTypeDto expenseTypeDto);

}
