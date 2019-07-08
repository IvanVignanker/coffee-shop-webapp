package com.coffeeshop.model.web.checkout;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ContactInfoDTORequest {

    @NotBlank
    @Length(min = 3, max = 20)
    private String firstName;

    @NotBlank
    @Length(min = 3, max = 20)
    private String lastName;

    @NotBlank @Length(min = 6, max = 20)
//    @Pattern(regexp = "^[+][0-9]", message = "Phone number may contain only numeric characters , leading by '+' ")
    private String phoneNumber;
}
