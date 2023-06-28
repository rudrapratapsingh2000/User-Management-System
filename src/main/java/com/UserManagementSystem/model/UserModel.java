package com.UserManagementSystem.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @NotNull
    private Integer UserId;
    @NotBlank
    private String username;
    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Invalid date of birth format. It should be in dd-MM-yyyy format.")
    private String DateOfBirth;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Invalid phone number format")
    @Size(min = 12, max = 12, message = "Phone number length should be 12 digits")
    private String phoneNumber;
}
