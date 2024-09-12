package com.smes.smes.adapters.in.controllers.create_manager_controller;

import com.smes.smes.application.usecases.CreateManagerUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
public class CreateManagerController {
    private final CreateManagerUseCase createManagerUseCase;

    public CreateManagerController(CreateManagerUseCase createManagerUseCase) {
        this.createManagerUseCase = createManagerUseCase;
    }

    @PostMapping()
    public void create(@RequestBody CreateManagerControllerBodyDto bodyDto) {
        this.createManagerUseCase.execute(
                bodyDto.name,
                bodyDto.email
        );
    }
}
