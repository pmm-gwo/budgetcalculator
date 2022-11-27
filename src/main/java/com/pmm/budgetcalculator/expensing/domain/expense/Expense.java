package com.pmm.budgetcalculator.expensing.domain.expense;

import com.pmm.budgetcalculator.foundation.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor

public class Expense extends BaseEntity {
    long expenseId;
    String expenseName;
    String expenseDescription;
    LocalDateTime expenseTime;
    double expenseAmount; //or BigDecimal
    String expensePlace;

    public Expense(){
        this.expenseTime = LocalDateTime.now();
    }
}
