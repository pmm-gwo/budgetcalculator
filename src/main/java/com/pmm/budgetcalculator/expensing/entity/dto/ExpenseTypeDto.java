package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseTypeDto extends BaseEntityDto {

    public String expenseTypeName;
}
