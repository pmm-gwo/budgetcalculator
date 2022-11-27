package com.pmm.budgetcalculator.foundation;

public interface AbstractService<E extends BaseEntity> {

  E add(E entity);
  E change(E entity);

}
