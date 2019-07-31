package com.coffeeshop.model.customer.web.checkout;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DeliveryDTORequest {

    @Length(min = 3, max = 100)
    private String officialName;

    @NotBlank @Length(min = 2, max = 20)
//    @Pattern(regexp = "^[a-zA-Z]", message = "City may contain only alphabet characters")
    private String city;

    @NotBlank @Length(min = 2, max = 20)
//    @Pattern(regexp = "^[a-zA-Z]", message = "Street may contain only alphabet characters")
    private String street;

    @Max(value = 10)
    private Integer houseNumber;

    @Max(value = 10)
    private Integer apartment;
    private Integer floor;

    @Length(max = 500)
    private String deliveryComment;
}
