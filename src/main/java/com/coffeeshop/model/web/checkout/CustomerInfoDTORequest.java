package com.coffeeshop.model.web.checkout;

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
    private String entityName;

    @NotBlank @Email @Length(min = 3, max = 20)
    private String email;
    private String phone;

    ContactInfoDTORequest contactInfoDTORequest;
}
