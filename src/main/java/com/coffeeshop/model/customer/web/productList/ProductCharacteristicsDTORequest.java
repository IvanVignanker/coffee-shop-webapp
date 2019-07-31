package com.coffeeshop.model.customer.web.productList;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ProductCharacteristicsDTORequest {

     private Integer bitterFrom;
     private Integer bitterTo;
     private Integer sourFrom;
     private Integer sourTo;
     private Integer strongFrom;
     private Integer strongTo;
     private Boolean decaf;
     private Boolean ground;
     private String coffeeType;
}
