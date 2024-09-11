package com.smes.smes.domain.usecases;

import com.smes.smes.domain.repositories.ManagersRepository;

import java.util.UUID;


public class RemoveManagerUseCase {
    private final ManagersRepository managersRepository;

    public RemoveManagerUseCase(ManagersRepository managersRepository){
        this.managersRepository = managersRepository;
    }

    public void execute(UUID managerId) throws Exception {
        this.managersRepository.remove(managerId);
    }
}
