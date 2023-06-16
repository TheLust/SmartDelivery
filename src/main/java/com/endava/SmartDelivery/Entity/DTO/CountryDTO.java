package com.endava.SmartDelivery.Entity.DTO;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {

    @NotBlank(message = "The name of a country cannot be blank.")
    private String name;

    @NotBlank(message = "The code of a country cannot be blank.")
    @Range(min = 2, max = 2, message = "The code should have 2 majuscule characters.")
    private String code;
}
