package com.coffeeshop.model.entity.product.productCoffee;

import com.coffeeshop.model.entity.base.BaseDate;
import com.coffeeshop.model.entity.product.product.Product;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCT_COFFEE")
public class ProductCoffee extends BaseDate {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    private Product product;

    @Column(name = "SOUR")
    private Integer sour;

    @Column(name = "BITTER")
    private Integer bitter;

    @Column(name = "STRONG")
    private Integer strong;

    @Column(name = "GROUND")
    private Boolean ground;

    @Column(name = "DECAF")
    private Boolean decaf;
}