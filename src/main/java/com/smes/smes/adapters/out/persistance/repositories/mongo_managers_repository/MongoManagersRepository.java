package com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.exceptions.ManagerNotFoundException;
import com.smes.smes.domain.repositories.ManagersRepository;


public class MongoManagersRepository implements ManagersRepository {
    private final SpringMongoManagerRepository springManagersRepository;

    public MongoManagersRepository(SpringMongoManagerRepository springManagersRepository) {
        this.springManagersRepository = springManagersRepository;
    }

    @Override
    public List<Manager> find() {
        List<ManagerMongoDatabaseEntity> dtos = this.springManagersRepository.findAll();
        return this.restoreAll(dtos);
    }

    @Override
    public void create(Manager manager) {
        ManagerMongoDatabaseEntity databaseManager = new ManagerMongoDatabaseEntity(
                manager.id,
                manager.name,
                manager.email
        );
        this.springManagersRepository.insert(this.springManagersRepository.insert(this.adapt(manager)));
    }

    @Override
    public void update(Manager manager) throws ManagerNotFoundException {
        this.springManagersRepository.save(this.adapt(manager));
    }

    @Override
    public void remove(UUID managerId) throws ManagerNotFoundException {
        this.springManagersRepository.deleteById(managerId.toString());
    }

    private ManagerMongoDatabaseEntity adapt(Manager manager) {
        return new ManagerMongoDatabaseEntity(
                manager.id,
                manager.name,
                manager.email
        );
    }

    private Manager restore(ManagerMongoDatabaseEntity dto) {
        return new Manager(dto.id, dto.name, dto.email);
    }

    private List<Manager> restoreAll(List<ManagerMongoDatabaseEntity> dtos) {
        ArrayList<Manager> managers = new ArrayList<>(dtos.size());
        for (ManagerMongoDatabaseEntity dto : dtos) {
            managers.add(this.restore(dto));
        }
        return managers;
    }

}
