package com.smes.smes.adapters.in.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.application.usecases.FindManagersUseCase;

@RestController
@RequestMapping("/managers")
public class FindManagersController {
    private final FindManagersUseCase findManagersUseCase;

    public FindManagersController(FindManagersUseCase findManagersUseCase){
        this.findManagersUseCase = findManagersUseCase;
    }

    @GetMapping()
    public List<Manager> find(){
        return this.findManagersUseCase.execute();
    }
}
