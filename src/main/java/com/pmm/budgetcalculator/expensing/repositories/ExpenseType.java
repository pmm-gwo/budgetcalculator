package com.pmm.budgetcalculator.expensing.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseType extends BaseEntity {

    @Enumerated(EnumType.STRING)
    ExpenseCategory expenseCategory;
}

