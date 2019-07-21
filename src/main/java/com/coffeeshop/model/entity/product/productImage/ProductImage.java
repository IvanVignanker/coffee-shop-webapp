package com.coffeeshop.model.entity.product.productImage;

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
@Table(name = "PRODUCT_IMAGE")
public class ProductImage extends BaseDate {

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", nullable = false)
    private Product product;

    @Column(name = "IMAGE", nullable = false)
    private byte[] image;
}