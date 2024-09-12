package com.smes.smes.adapters.out.persistance.repositories;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.smes.smes.domain.repositories.ManagersRepository;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smes.smes.domain.entities.Manager;

@SpringBootTest
class InMemoryManagersRepositoryTests {

    @Autowired
    ManagersRepository managersRepository;


    @Test
    void shouldReturnAllManagers() {
        List<Manager> managers = this.managersRepository.find();
        assertEquals(3, managers.spliterator().getExactSizeIfKnown());
    }

}
