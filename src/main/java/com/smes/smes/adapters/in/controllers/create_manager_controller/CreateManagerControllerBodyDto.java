package com.smes.smes.adapters.in.controllers.create_manager_controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class CreateManagerControllerBodyDto {
    @NotNull
    @NotEmpty
    @Size(min = 1)
    public String name;

    @NotNull
    @Email
    @NotEmpty
    @Size(min = 1)
    public String email;

    public CreateManagerControllerBodyDto(
            String name,
            String email
    ) {
        this.name = name;
        this.email = email;
    }
}