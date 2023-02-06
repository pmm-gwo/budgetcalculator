package com.pmm.budgetcalculator.expensing.entity.dto;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpensePlanDto {

    private String expensePlanName;
    private String expensePlanDescription;
    private Date expensePlanTime;
    private BigDecimal expensePlanAmount;
    private ExpenseCategory category;
}


