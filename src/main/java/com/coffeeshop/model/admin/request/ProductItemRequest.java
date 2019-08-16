package com.coffeeshop.model.admin.request;

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
    private Long productId;
    @Min(value = 1)
    private Integer weightKG;
}
