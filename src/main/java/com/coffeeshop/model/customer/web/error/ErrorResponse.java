package com.coffeeshop.model.customer.web.error;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
@Getter
public class ErrorResponse {

    private String message;
    private Object errors;
}