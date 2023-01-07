package com.pmm.budgetcalculator.expensing.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Expense extends BaseEntity {

    @NotBlank(message = "this field is mandatory")
    private String expenseName;
    private String expenseDescription;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expenseTime;
    @NotNull
    private BigDecimal expenseAmount;
    @Size(min = 1, max = 30, message = "Must be between 1 and 30 characters")
    private String expensePlace;
    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseType> expenseTypes;
    //    @NotNull(message = "this field is mandatory")
    @ManyToOne(fetch = FetchType.EAGER)
    private ExpenseCategory expenseCategory;

}
