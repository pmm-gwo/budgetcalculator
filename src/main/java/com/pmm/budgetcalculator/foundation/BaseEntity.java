package com.pmm.budgetcalculator.foundation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass // sygnal dla Spring i JPA aby atrybuty klasy zmapowac jako atrybuty encji
@Data
@EqualsAndHashCode(of = "id")
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @Version
    protected int version;
}
