package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityDto {

    public Long id;
    public int version;
    public Date registrationTime = new Date();
}


