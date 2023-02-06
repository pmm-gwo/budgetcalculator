package com.pmm.budgetcalculator.expensing.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntityDto {
    @Id
    protected Long id;
}


