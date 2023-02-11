package com.pmm.budgetcalculator.expensing.entity.dto;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

public class ExpensePlanDto extends BaseEntityDto{

    public String expensePlanName;
    public String expensePlanDescription;
    public Date expensePlanTime;
    public BigDecimal expensePlanAmount;
    public ExpenseCategory category;
}


