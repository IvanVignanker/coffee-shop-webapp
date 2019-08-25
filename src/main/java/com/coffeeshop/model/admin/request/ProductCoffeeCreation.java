package com.coffeeshop.model.admin.request;

import com.coffeeshop.model.customer.entity.product.product.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCoffeeCreation {

    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    @ApiModelProperty(example = "2")
    private Integer sour;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    @ApiModelProperty(example = "2")
    private Integer bitter;

    @Min(value = 1)
    @Max(value = 5)
    @NotNull
    @ApiModelProperty(example = "2")
    private Integer strong;

    @NotNull
    @ApiModelProperty(example = "true")
    private Boolean ground;

    @NotNull
    @ApiModelProperty(example = "true")
    private Boolean decaf;
}
