package com.coffeeshop.model.entity.product.productItem;

import com.coffeeshop.model.entity.base.BaseDate;
import com.coffeeshop.model.entity.product.Product;
import com.coffeeshop.model.entity.product.productItem.converter.ProductStatusConverter;
import com.coffeeshop.model.entity.product.productItem.status.ProductStatus;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCT_ITEM")
public class ProductItem extends BaseDate {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    private Product product;

    @Column(name = "WEIGHT_KG", nullable = false)
    private Integer weightKG;

    @Column(name = "STATUS")
    @Convert(converter = ProductStatusConverter.class)
    private ProductStatus status;

    @Column(name = "VERSION")
    @Version
    private Integer version;
}