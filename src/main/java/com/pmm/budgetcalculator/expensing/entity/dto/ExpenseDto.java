package com.pmm.budgetcalculator.expensing.entity.dto;

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

public class ExpenseDto extends BaseEntityDto{

    public String expenseName;
    public String expensePlace;
    public String expenseDescription;
    public Date expenseTime;
    public BigDecimal expenseAmount;
}


