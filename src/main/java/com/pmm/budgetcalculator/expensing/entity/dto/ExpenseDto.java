package com.pmm.budgetcalculator.expensing.entity.dto;

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
public class ExpenseDto {
    // ExpenseDetails = 'expenseName' + 'expensePlace'
    public String expenseName;
    public String expensePlace;
    public String expenseDescription;
    public Date expenseTime;
    public BigDecimal expenseAmount;

}


