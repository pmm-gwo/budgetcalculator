package com.pmm.budgetcalculator.expensing.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Expense extends BaseEntity {

    private String expenseName;
    private String expenseDescription;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expenseTime;
    private BigDecimal expenseAmount;
    private String expensePlace;
    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<ExpenseType> expenseTypeList;

    @ManyToMany
    @JoinTable(name = "expense_type",
            joinColumns = @JoinColumn(name = "expense_id", referencedColumnName = "type_id"))
    private Set<ExpenseType> expenseTypes = new LinkedHashSet<>();

    public Set<ExpenseType> getExpenseTypes() {
        return expenseTypes;
    }

    public void setExpenseTypes(Set<ExpenseType> expenseTypes) {
        this.expenseTypes = expenseTypes;
    }
}
