package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class BaseEntityDto {
    @Id
    protected Long id;
}


