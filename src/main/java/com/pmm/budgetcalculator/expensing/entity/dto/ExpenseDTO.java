package com.pmm.budgetcalculator.expensing.entity.dto;

import com.pmm.budgetcalculator.expensing.entity.ExpenseCategory;
import com.pmm.budgetcalculator.expensing.entity.ExpenseType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ExpenseDTO {
    public String expenseName;
    public String expenseDescription;
    public Date expenseTime;
    public BigDecimal expenseAmount;
    public String expensePlace;
    public List<ExpenseType> expenseTypes;
    public ExpenseCategory expenseCategory;
}


