package com.smes.smes.application.usecases;

import java.util.List;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.repositories.ManagersRepository;


public class FindManagersUseCase {
    private final ManagersRepository managersRepository;

    public FindManagersUseCase(ManagersRepository managersRepository){
        this.managersRepository = managersRepository;
    }

    public List<Manager> execute(){
        return this.managersRepository.find();
    }
}
