package com.coffeeshop.model.customer.web.productList;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductCharacteristicsDTORequest {

     @ApiModelProperty(example = "1")
     private Integer bitterFrom;
     @ApiModelProperty(example = "5")
     private Integer bitterTo;
     @ApiModelProperty(example = "1")
     private Integer sourFrom;
     @ApiModelProperty(example = "5")
     private Integer sourTo;
     @ApiModelProperty(example = "1")
     private Integer strongFrom;
     @ApiModelProperty(example = "5")
     private Integer strongTo;
     @ApiModelProperty(example = "true")
     private Boolean decaf;
     @ApiModelProperty(example = "true")
     private Boolean ground;
     @ApiModelProperty(example = "arabica")
     private String coffeeType;
}
