package com.coffeeshop.model.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Setter @Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false, unique = true)
    private Long id;
}