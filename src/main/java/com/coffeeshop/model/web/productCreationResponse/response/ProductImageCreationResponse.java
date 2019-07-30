package com.coffeeshop.model.web.productCreationResponse.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductImageCreationResponse {

    private Long id;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private byte[] image;
}
