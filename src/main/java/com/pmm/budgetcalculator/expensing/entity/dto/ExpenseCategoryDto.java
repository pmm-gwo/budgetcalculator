package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseCategoryDto {
    private String expenseCategoryName;
}

