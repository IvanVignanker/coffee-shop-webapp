package com.coffeeshop.model.admin.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductCoffeeCreationResponse {

    private Long id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Integer sour;
    private Integer bitter;
    private Integer strong;
    private Boolean ground;
    private Boolean decaf;
}
