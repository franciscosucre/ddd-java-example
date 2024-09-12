package com.smes.smes.adapters.in.controllers.update_manager_controller;

import com.smes.smes.application.usecases.UpdateManagerUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/managers")
public class UpdateManagerController {
    private final UpdateManagerUseCase updateManagerUseCase;

    public UpdateManagerController(UpdateManagerUseCase updateManagerUseCase) {
        this.updateManagerUseCase = updateManagerUseCase;
    }

    @PatchMapping("/{managerId}")
    public void update(@PathVariable(value = "managerId") UUID managerId, @RequestBody UpdateManagerControllerBodyDto bodyDto) throws Exception {
        this.updateManagerUseCase.execute(managerId,
                Optional.ofNullable(bodyDto.name),
                Optional.ofNullable(bodyDto.email)
        );
    }
}
