package com.pmm.budgetcalculator.foundation;

public interface AbstractFactory<E extends BaseEntity> {

  E create();

}
