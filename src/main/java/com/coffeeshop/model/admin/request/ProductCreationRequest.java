package com.coffeeshop.model.admin.request;

import com.coffeeshop.model.customer.entity.product.product.status.ProductType;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "Jamaican Blue Mountain Coffee")
    private String productName;

    @NotBlank
    @ApiModelProperty(example = "Jamaica Blue Mountain Coffee is typically wet " +
            "processed and is very well balanced with a full body.")
    private String shortDescription;

    @Length(min = 6, max = 500)
    @ApiModelProperty(example = "A sophisticated coffee is a wet processed coffee " +
            "that is silky smooth and well-balanced, " +
            "with an excellent full body, " +
            "a classic and refined mild taste with a slightly sweet flavor.")
    private String description;

    @ApiModelProperty(example = "SGVsbG8sIFdvcmxkIQ==")
    private String previewImage;

    @Min(value = 1)
    @NotNull
    @ApiModelProperty(example = "99.99")
    private Double unitPrice;
    private ProductType productCategoryId;
}
