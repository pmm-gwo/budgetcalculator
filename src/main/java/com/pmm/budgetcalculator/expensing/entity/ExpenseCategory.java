package com.pmm.budgetcalculator.expensing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseCategory extends BaseEntity {

    @NotBlank(message = "this field is mandatory")
    private String expenseCategoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ExpensePlan> expensePlans;
    @OneToMany(mappedBy = "expenseCategory", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Expense> expenses;
}
