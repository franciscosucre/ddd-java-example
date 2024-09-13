package com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringPostgresManagerRepository extends JpaRepository<ManagerPostgresDatabaseEntity, UUID> {

}
