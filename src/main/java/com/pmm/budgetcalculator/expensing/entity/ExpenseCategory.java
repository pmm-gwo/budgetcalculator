package com.pmm.budgetcalculator.expensing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseCategory extends BaseEntity{


    private String expenseCategory;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<ExpensePlan> expensePlans;
}
