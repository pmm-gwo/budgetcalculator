package com.pmm.budgetcalculator.expensing.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Expense extends BaseEntity {

    @NotBlank
    private String expenseName;
    private String expenseDescription;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expenseTime;
    @NotNull
    private BigDecimal expenseAmount;
    private String expensePlace;
    @NonNull
    @ManyToMany
    private List<ExpenseType> expenseTypes;
    @ManyToOne(fetch = FetchType.EAGER)
    private ExpenseCategory category;

}
