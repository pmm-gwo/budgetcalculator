package com.pmm.budgetcalculator.expensing.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
@Data
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor

public abstract class BaseEntity {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    protected int version;

    @CreatedDate
    @Column(name = "registration_time")
    protected Date registrationTime = new Date();

}
