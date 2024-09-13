package com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.exceptions.ManagerNotFoundException;
import com.smes.smes.domain.repositories.ManagersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class PostgresManagersRepository implements ManagersRepository {
    private final SpringPostgresManagerRepository springPostgresManagersRepository;

    public PostgresManagersRepository(SpringPostgresManagerRepository springPostgresManagersRepository) {
        this.springPostgresManagersRepository = springPostgresManagersRepository;
    }

    @Override
    public List<Manager> find() {
        List<ManagerPostgresDatabaseEntity> dtos = this.springPostgresManagersRepository.findAll();
        return this.restoreAll(dtos);
    }

    @Override
    public void create(Manager manager) {
        ManagerPostgresDatabaseEntity databaseManager = new ManagerPostgresDatabaseEntity(
                manager.id,
                manager.name,
                manager.email
        );
        this.springPostgresManagersRepository.save(this.adapt(manager));
    }

    @Override
    public void update(Manager manager) throws ManagerNotFoundException {
        this.springPostgresManagersRepository.save(this.adapt(manager));
    }

    @Override
    public void remove(UUID managerId) throws ManagerNotFoundException {
        this.springPostgresManagersRepository.deleteById(managerId);
    }

    private ManagerPostgresDatabaseEntity adapt(Manager manager) {
        return new ManagerPostgresDatabaseEntity(
                manager.id,
                manager.name,
                manager.email
        );
    }

    private Manager restore(ManagerPostgresDatabaseEntity dto) {
        return new Manager(dto.id, dto.name, dto.email);
    }

    private List<Manager> restoreAll(List<ManagerPostgresDatabaseEntity> dtos) {
        ArrayList<Manager> managers = new ArrayList<>(dtos.size());
        for (ManagerPostgresDatabaseEntity dto : dtos) {
            managers.add(this.restore(dto));
        }
        return managers;
    }

}
