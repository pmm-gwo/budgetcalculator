package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.Data;

import java.util.Date;
@Data

public class BaseEntityDTO {
    protected Long id;
    protected int version;
    protected Date registrationTime = new Date();
}


