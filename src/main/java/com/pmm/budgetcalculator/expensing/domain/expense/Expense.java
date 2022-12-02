package com.pmm.budgetcalculator.expensing.domain.expense;

import com.pmm.budgetcalculator.foundation.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;


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


}
