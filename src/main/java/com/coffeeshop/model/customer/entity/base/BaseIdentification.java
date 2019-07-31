package com.coffeeshop.model.customer.entity.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@MappedSuperclass
public abstract class BaseIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false, unique = true)
    private Long id;
}