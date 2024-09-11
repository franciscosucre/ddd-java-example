package com.smes.smes.infrastructure.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.repositories.ManagersRepository;

@Repository
public class InMemoryManagersRepository implements ManagersRepository {
    private List<Manager> managers = List.of(
        new Manager(UUID.fromString("b013cd74-99f6-418d-93a7-ed1863da6f5e"), "Milingo", "milingo@cobee.io"),
        new Manager(UUID.fromString("6b2b6fef-2e33-4adc-a892-27657f960848"), "Jose", "jose@cobee.io"),
        new Manager(UUID.fromString("61508a31-06d5-44bc-b5e2-a2be44ba1cef"), "Paco", "paco@cobee.io")
    );


    @Override
    public List<Manager> find() {
        return this.managers;
    }

    @Override
    public void create(Manager manager) {
        this.managers.add(manager);
    }
}
