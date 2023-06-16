package com.endava.SmartDelivery.Entity.DTO;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Username should not be blank or empty")
    private String username;

    @NotBlank(message = "Username should not be blank or empty")
    @Length(min = 8, message = "Password ")
    private String password;

    @NotBlank(message = "Role should not be blank or empty")
    private String role;

}

