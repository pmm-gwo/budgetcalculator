package com.pmm.budgetcalculator.foundation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass // sygnal dla Spring i JPA aby atrybuty klasy zmapowac jako atrybuty encji
@Data
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)

public abstract class BaseEntity {
    @NonNull
    @Id
    @GeneratedValue
    protected Long id;

    @Version
    protected int version;

    @CreatedDate
    @Column(name = "registration_time")
    protected Date registrationTime = new Date();

    protected BaseEntity() {
    }
}
