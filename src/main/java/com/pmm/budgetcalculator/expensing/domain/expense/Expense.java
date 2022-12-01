package com.pmm.budgetcalculator.expensing.domain.expense;

import com.pmm.budgetcalculator.foundation.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Expense extends BaseEntity {

    private String expenseName;
    private String expenseDescription;
    private String expenseTime;
    private BigDecimal expenseAmount;
    private String expensePlace;

    public Expense(String expenseTime) {
        this.expenseTime = "dd-MM-yyyy";
    }

}
