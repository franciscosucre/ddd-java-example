package com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;


@Entity
@Table(name = "managers")
public class ManagerPostgresDatabaseEntity {

    public ManagerPostgresDatabaseEntity(){}

    public ManagerPostgresDatabaseEntity(UUID id, String name, String email) {
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
