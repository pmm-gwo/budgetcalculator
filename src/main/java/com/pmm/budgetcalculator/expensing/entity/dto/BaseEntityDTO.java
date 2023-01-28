package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.Data;

import javax.persistence.Id;
@Data
public class BaseEntityDTO {
    @Id
    protected Long id;
}


