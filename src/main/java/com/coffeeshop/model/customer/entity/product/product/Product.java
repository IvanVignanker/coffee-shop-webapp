package com.coffeeshop.model.customer.entity.product.product;

import com.coffeeshop.model.customer.entity.base.BaseDate;
import com.coffeeshop.model.customer.entity.product.product.converter.ProductTypeConverter;
import com.coffeeshop.model.customer.entity.product.product.status.ProductType;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseDate {

    @Column(name = "TITLE", length = 30, nullable = false)
    private String title;

    @Column(name = "SHORT_DESCRIPTION", length = 100, nullable = false)
    private String shortDescription;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PREVIEW_IMAGE", nullable = false)
    private String previewImage;

    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unitPrice;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false)
    @Convert(converter = ProductTypeConverter.class)
    private ProductType productCategoryId;

    @Column(name = "AVAILABLE")
    private Boolean available = false;

    @Column(name = "VERSION")
    @Version
    private Integer version;
}