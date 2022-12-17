package com.pmm.budgetcalculator.expensing.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
    @NonNull
    private BigDecimal expenseAmount;
    private String expensePlace;
    @NonNull
    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<ExpenseType> expenseTypes;

}
