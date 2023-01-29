package com.pmm.budgetcalculator.expensing.entity.mapper;

import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import com.pmm.budgetcalculator.expensing.entity.dto.ExpenseTypeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseTypeMapper {
    ExpenseTypeDto entityToDto(ExpenseType expenseType);

    ExpenseType dtoToEntity(ExpenseTypeDto expenseTypeDto);

    List<ExpenseTypeDto> entityListToDtoList(List<ExpenseType> expenseTypeList);

    List<ExpenseType> dtoListToEntityList(List<ExpenseTypeDto> expenseTypeDtoListList);
}
