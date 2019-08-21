package com.coffeeshop.model.admin.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductItemRequest {

    @NotNull
    @ApiModelProperty(example = "1")
    private Long productId;

    @Min(value = 1)
    @ApiModelProperty(example = "200")
    private Integer weightKG;
}