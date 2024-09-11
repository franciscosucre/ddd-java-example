package com.smes.smes.infrastructure.repositories.mongo_managers_repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.repositories.ManagersRepository;


public class MongoManagersRepository implements ManagersRepository {
    private final SpringManagerRepository springManagersRepository;

    public MongoManagersRepository(SpringManagerRepository springManagersRepository) {
        this.springManagersRepository = springManagersRepository;
    }

    @Override
    public List<Manager> find() {
        List<ManagerDatabaseEntity> dtos = this.springManagersRepository.findAll();
        return this.restoreAll(dtos);
    }

    @Override
    public void create(Manager manager) {
        ManagerDatabaseEntity databaseManager = new ManagerDatabaseEntity(
                manager.id,
                manager.name,
                manager.email
        );
        this.springManagersRepository.insert(this.springManagersRepository.insert(this.adapt(manager)));
    }

    @Override
    public void remove(UUID managerId) throws Exception {
        this.springManagersRepository.deleteById(managerId.toString());
    }

    private ManagerDatabaseEntity adapt(Manager manager) {
        return new ManagerDatabaseEntity(
                manager.id,
                manager.name,
                manager.email
        );
    }

    private Manager restore(ManagerDatabaseEntity dto) {
        return new Manager(dto.id, dto.name, dto.email);
    }

    private List<Manager> restoreAll(List<ManagerDatabaseEntity> dtos) {
        ArrayList<Manager> managers = new ArrayList<>(dtos.size());
        for (ManagerDatabaseEntity dto : dtos) {
            managers.add(this.restore(dto));
        }
        return managers;
    }

}
