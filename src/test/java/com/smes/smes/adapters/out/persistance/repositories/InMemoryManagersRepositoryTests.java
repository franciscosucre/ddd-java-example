package com.smes.smes.adapters.out.persistance.repositories;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.smes.smes.AbstractBaseIntegrationTest;
import com.smes.smes.configs.MongoConfiguration;
import com.smes.smes.configs.PostgresConfiguration;
import com.smes.smes.domain.repositories.ManagersRepository;
import org.junit.jupiter.api.Test;


import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smes.smes.domain.entities.Manager;

class InMemoryManagersRepositoryTests  {

    InMemoryManagersRepository inMemoryManagersRepository = new InMemoryManagersRepository();


    @Test
    void shouldReturnAllManagers() {
        List<Manager> managers = this.inMemoryManagersRepository.find();
        assertEquals(3, managers.spliterator().getExactSizeIfKnown());
    }

}
