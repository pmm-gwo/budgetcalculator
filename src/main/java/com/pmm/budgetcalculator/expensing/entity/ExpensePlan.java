package com.pmm.budgetcalculator.expensing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class ExpensePlan extends BaseEntity {

    @NotBlank(message = "this field is mandatory")
    private String expensePlanName;
    private String expensePlanDescription;
    @NotNull
    @Future
    @DateTimeFormat(pattern = "MM")
    private Date expensePlanTime;
    @NotNull
    private BigDecimal expensePlanAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotBlank(message = "this field is mandatory")
    private ExpenseCategory category;


}
