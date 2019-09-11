package com.coffeeshop.model.customer.web.productList;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Builder
public class ProductListDTORequest {

    @ApiModelProperty(example = "1")
    private Long page;
    @ApiModelProperty(example = "10")
    private Integer results;
    @ApiModelProperty(example = "Jamaican Arabica")
    private String search;
    @ApiModelProperty(example = "10")
    private Double priceMin;
    @ApiModelProperty(example = "100")
    private Double priceMax;

    @ApiModelProperty(example = "popular | price | name")
    private String sortBy;

    ProductCharacteristicsDTORequest characteristics;
}
