package com.smes.smes.adapters.out.persistance.repositories;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import com.smes.smes.domain.entities.Manager;

class InMemoryManagersRepositoryTests  {

    InMemoryManagersRepository inMemoryManagersRepository = new InMemoryManagersRepository();


    @Test
    void shouldReturnAllManagers() {
        List<Manager> managers = this.inMemoryManagersRepository.find();
        assertEquals(3, managers.spliterator().getExactSizeIfKnown());
    }

}
