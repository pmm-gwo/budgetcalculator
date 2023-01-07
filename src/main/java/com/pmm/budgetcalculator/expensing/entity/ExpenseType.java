package com.pmm.budgetcalculator.expensing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseType extends BaseEntity {

//    @NotBlank(message = "this field is mandatory")
    private String expenseTypeName;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="expense_id")
//    @JoinTable(
//            name = "types_expenses",
//            joinColumns = @JoinColumn(name = "expense_id"),
//            inverseJoinColumns = @JoinColumn(name = "expenseType_id")
//    )
    private Expense expense;

}
