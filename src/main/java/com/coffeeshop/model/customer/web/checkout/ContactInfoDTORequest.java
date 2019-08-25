package com.coffeeshop.model.customer.web.checkout;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ContactInfoDTORequest {

    @NotBlank
    @Length(min = 3, max = 20)
    @ApiModelProperty(example = "John")
    private String firstName;

    @NotBlank
    @Length(min = 3, max = 20)
    @ApiModelProperty(example = "Doe")
    private String lastName;

    @NotBlank @Length(min = 6, max = 20)
//    @Pattern(regexp = "^[+][0-9]", message = "Phone number may contain only numeric characters , leading by '+' ")
    @ApiModelProperty(example = "+972501112233")
    private String phoneNumber;
}
