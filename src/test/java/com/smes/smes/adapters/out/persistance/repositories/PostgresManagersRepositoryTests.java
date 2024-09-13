package com.smes.smes.adapters.out.persistance.repositories;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.smes.smes.AbstractBaseIntegrationTest;
import com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository.ManagerPostgresDatabaseEntity;
import com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository.PostgresManagersRepository;
import com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository.SpringPostgresManagerRepository;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smes.smes.domain.entities.Manager;

@SpringBootTest
class PostgresManagersRepositoryTests extends AbstractBaseIntegrationTest {

    @Autowired
    PostgresManagersRepository postgresManagersRepository;

    @Autowired
    SpringPostgresManagerRepository springPostgresManagerRepository;


    @Test
    void shouldReturnNoManagers() {
        List<Manager> managers = this.postgresManagersRepository.find();
        assertEquals(0, managers.spliterator().getExactSizeIfKnown());
    }

    @Test
    void shouldReturnTwoManagers() {

        this.springPostgresManagerRepository.save(
                new ManagerPostgresDatabaseEntity(
                        UUID.fromString("0a18144c-aedb-4992-a2b5-5f6781a6db54"),
                        "Test 1",
                        "test1@test.io"
                )
        );
        this.springPostgresManagerRepository.save(
                new ManagerPostgresDatabaseEntity(
                        UUID.fromString("112d92ed-1492-471a-b947-83a7f358af4b"),
                        "Test 2",
                        "test2@test.io"
                )
        );

        List<Manager> managers = this.postgresManagersRepository.find();
        assertEquals(2, managers.spliterator().getExactSizeIfKnown());
    }

}
