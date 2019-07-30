package com.coffeeshop.model.web.productCreationResponse.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductQuantityCreationResponse {

    private Long id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Integer quantity;
    private Integer version;
}
