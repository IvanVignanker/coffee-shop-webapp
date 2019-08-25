package com.coffeeshop.model.customer.web.checkout;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CustomerInfoDTORequest {

    @Length(min = 3, max = 100)
    @ApiModelProperty(example = "Pret a Manger")
    private String entityName;

    @NotBlank @Email @Length(min = 3, max = 20)
    @ApiModelProperty(example = "john.doe@site.com")
    private String email;

    @ApiModelProperty(example = "+972501112233")
    private String phone;

    ContactInfoDTORequest contactInfoDTORequest;
}
