package com.smes.smes.application.usecases;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.repositories.ManagersRepository;

import java.util.List;
import java.util.UUID;


public class CreateManagerUseCase {
    private final ManagersRepository managersRepository;

    public CreateManagerUseCase(ManagersRepository managersRepository){
        this.managersRepository = managersRepository;
    }

    public void execute(String name, String email){
        Manager manager = new Manager(
                UUID.randomUUID(),
                name,
                email
        );
        this.managersRepository.create(manager);
    }
}
