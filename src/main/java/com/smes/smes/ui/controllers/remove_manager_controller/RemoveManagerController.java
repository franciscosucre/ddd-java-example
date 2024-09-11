package com.smes.smes.ui.controllers.remove_manager_controller;

import com.smes.smes.domain.usecases.RemoveManagerUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/managers")
public class RemoveManagerController {
    private final RemoveManagerUseCase removeManagerUseCase;

    public RemoveManagerController(RemoveManagerUseCase removeManagerUseCase) {
        this.removeManagerUseCase = removeManagerUseCase;
    }

    @DeleteMapping("/{managerId}")
    public void remove(@PathVariable(value="managerId") UUID managerId) throws Exception {
        this.removeManagerUseCase.execute(managerId);
    }
}
