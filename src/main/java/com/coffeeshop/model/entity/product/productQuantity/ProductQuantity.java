package com.coffeeshop.model.entity.product.productQuantity;

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
@Table(name = "PRODUCT_QUANTITY")
public class ProductQuantity extends BaseDate {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    private Product product;

    @Column(name = "VERSION")
    @Version
    private Integer version;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}
