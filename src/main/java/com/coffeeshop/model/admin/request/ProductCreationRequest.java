package com.coffeeshop.model.admin.request;

import com.coffeeshop.model.customer.entity.product.product.status.ProductType;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class ProductCreationRequest {

    @NotBlank
    private String shortDescription;

    @Length(min = 6, max = 500)
    private String description;
    private String previewImage;

    @Min(value = 1)
    @NotNull
    private Double unitPrice;
    private ProductType productCategoryId;
    private Boolean available;
    private Integer version;
}
