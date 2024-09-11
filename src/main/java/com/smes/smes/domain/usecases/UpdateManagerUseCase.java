package com.smes.smes.domain.usecases;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.exceptions.ManagerNotFoundException;
import com.smes.smes.domain.repositories.ManagersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class UpdateManagerUseCase {
    private final ManagersRepository managersRepository;

    public UpdateManagerUseCase(ManagersRepository managersRepository) {
        this.managersRepository = managersRepository;
    }

    public void execute(UUID managerId, Optional<String> name, Optional<String> email) throws ManagerNotFoundException {
        List<Manager> managers = this.managersRepository.find();

        Manager managerToUpdate = managers.stream()
                .filter(x -> x.id.equals(managerId))
                .findFirst().orElseThrow(() -> new ManagerNotFoundException(managerId));

        String newName = name.orElseGet(() -> managerToUpdate.name);
        String newEmail = email.orElseGet(() -> managerToUpdate.email);

        Manager updatedManager = new Manager(
                managerId,
                newName,
                newEmail
        );

        this.managersRepository.update(updatedManager);
    }
}
