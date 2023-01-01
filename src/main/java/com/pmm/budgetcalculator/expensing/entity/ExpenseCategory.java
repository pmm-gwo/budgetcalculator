package com.pmm.budgetcalculator.expensing.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity(name="category")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor

public class ExpenseCategory extends BaseEntity {

    @NotNull
    @NotBlank(message = "this field is mandatory")
    private String expenseCategoryName;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<ExpensePlan> expensePlans;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Expense> expenses;
}
