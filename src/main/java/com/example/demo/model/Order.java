package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @NotBlank(message = "Select a cake flavor")
    String cakeFlavor;

    @Min(value = 1, message = "Must be greater than or equal 1")
    @Max(value = 10, message = "Must be less than or equal to 10")
    int quantity = 1;

    @NotNull(message = "Required")
    @Future(message = "Must be a future date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date deliveryDate;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "Must be 3 to 30 characters long and must be alphanumeric")
    String firstName;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,30}$", message = "Must be 3 to 30 characters long and must be alphanumeric")
    String lastName;

    @Digits(integer = 11, fraction = 0, message = "Must be composed of digits")
    @Size(min = 8, max = 11, message = "Must be between 8 to 11 digits")
    String contactNo;

    @NotEmpty(message = "Required")
    @Email(message = "Invalid email address")
    String email;

    @NotNull(message = "Required")
    @Past(message = "Must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthDate;

    @AssertTrue(message = "Please agree to our terms and conditions")
    boolean agreedToTNC;
}