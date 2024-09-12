package com.smes.smes.adapters.in.controllers.update_manager_controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UpdateManagerControllerBodyDto {
    @NotEmpty
    @Size(min = 1)
    public String name;

    @Email
    @NotEmpty
    @Size(min = 1)
    public String email;

    public UpdateManagerControllerBodyDto(
            String name,
            String email
    ) {
        this.name = name;
        this.email = email;
    }
}