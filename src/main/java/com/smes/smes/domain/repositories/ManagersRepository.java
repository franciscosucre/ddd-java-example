package com.smes.smes.domain.repositories;

import java.util.List;
import java.util.UUID;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.exceptions.ManagerNotFoundException;

public interface ManagersRepository {
    public List<Manager> find();

    public void create(Manager manager);

    public void update(Manager manager) throws  ManagerNotFoundException;

    public void remove(UUID managerId) throws ManagerNotFoundException;
}
