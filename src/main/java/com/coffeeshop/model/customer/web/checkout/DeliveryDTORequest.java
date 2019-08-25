package com.coffeeshop.model.customer.web.checkout;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(example = "name on the package")
    private String officialName;

    @NotBlank @Length(min = 2, max = 20)
    @ApiModelProperty(example = "Eilat")
    private String city;

    @NotBlank @Length(min = 2, max = 20)
    @ApiModelProperty(example = "Rotshild")
    private String street;

    @ApiModelProperty(example = "11")
    private String houseNumber;

    @ApiModelProperty(example = "115")
    private String apartment;
    @ApiModelProperty(example = "1")
    private String floor;

    @Length(max = 500)
    @ApiModelProperty(example = "Should be delivered between 13.00 - 15.00")
    private String deliveryComment;
}