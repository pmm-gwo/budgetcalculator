package com.pmm.budgetcalculator.expensing.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class ExpensePlan extends BaseEntity {

    private String expensePlanName;
    private String expensePlanDescription;
    @NonNull
    @DateTimeFormat(pattern = "MM")
    private Date expensePlanTime;
    @NonNull
    private BigDecimal expensePlanAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @NonNull
    private ExpenseCategory category;


}
