package com.example.sb_ecommerce.Api.Model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegistrationBody {
    @NotEmpty
    @NotBlank
    private String username;
    @Email
    @NotEmpty
    @NotBlank
    private String email;
    @NotEmpty
    @NotBlank
    //@Pattern(regexp = ("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)$"))
    @Size(min = 8, max = 12)
    private String password;
    @NotEmpty
    @NotBlank
    private String firstName;
    private String lastName;

}
