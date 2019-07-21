package com.coffeeshop.model.entity.product.product;

import com.coffeeshop.model.entity.base.BaseDate;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseDate {

    @Column(name = "SHORT_DESCRIPTION", length = 100, nullable = false)
    private String shortDescription;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PREVIEW_IMAGE", nullable = false)
    private String previewImage;

    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unitPrice;

    @Column(name = "PRODUCT_CATEGORY_ID", nullable = false)
    private Integer productCategoryId;

    @Column(name = "AVAILABLE")
    private Boolean available;

    @Column(name = "VERSION")
    @Version
    private Integer version;
}