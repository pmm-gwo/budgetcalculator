package com.pmm.budgetcalculator.expensing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseType extends BaseEntity {

    private String expenseTypeName;
    @ManyToMany(mappedBy = "expenseTypes")
//    @JoinTable(
//            name = "types_expenses",
//            joinColumns = @JoinColumn(name = "expense_id"),
//            inverseJoinColumns = @JoinColumn(name = "expenseType_id")
//    )
    private List<Expense> expenses;

}
