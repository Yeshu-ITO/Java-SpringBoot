package com.yeshu.blogApp.BlogApplication.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be minimum of 4 characters")
    private String name;
    @Email(message = "Email not Valid")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 5,max = 12, message = "Password must be at least 5 characters and less than 12 characters")
    private String password;
    @NotEmpty
    private String about;
}
