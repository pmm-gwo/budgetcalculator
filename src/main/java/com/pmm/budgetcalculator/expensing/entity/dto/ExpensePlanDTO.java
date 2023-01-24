package com.pmm.budgetcalculator.expensing.entity.dto;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpensePlanDTO {

    private String expensePlanName;
    private String expensePlanDescription;
    private Date expensePlanTime;
    private BigDecimal expensePlanAmount;
    private ExpenseCategory category;
}


