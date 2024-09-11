package com.smes.smes.domain.repositories;

import java.util.List;
import java.util.UUID;

import com.smes.smes.domain.entities.Manager;

public interface ManagersRepository {
    public List<Manager> find();

    public void create(Manager manager);
}
