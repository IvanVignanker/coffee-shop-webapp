package com.coffeeshop.model.customer.web;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class ProductImageDto {

    @NotNull
    @ApiModelProperty(example = "1")
    private Long productId;

    @ApiModelProperty(dataType = "List<file>", example = "[1.jpg,2.jpg]")
    private List<String> images;
}