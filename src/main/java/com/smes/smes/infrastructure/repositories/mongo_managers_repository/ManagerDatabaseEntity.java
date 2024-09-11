package com.smes.smes.infrastructure.repositories.mongo_managers_repository;

import org.springframework.data.annotation.Id;

import java.util.UUID;



public class ManagerDatabaseEntity {

    public ManagerDatabaseEntity(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Id
    public UUID id;

    public String name;

    public String email;

    @Override
    public String toString() {
        return "ManagerDatabaseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
