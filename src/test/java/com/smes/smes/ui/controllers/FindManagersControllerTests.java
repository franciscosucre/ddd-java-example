package com.smes.smes.ui.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.usecases.FindManagersUseCase;

@SpringBootTest
class FindManagersControllerTests {

  @MockBean
  FindManagersUseCase findManagersUseCase;


  @Autowired
  FindManagersController findManagersController;


  @Test
  void shouldReturnAllManagers() {
    List<Manager> managers = List.of(
            new Manager(UUID.fromString("14e966b9-ab1d-45d0-aab9-10c3b4e4e771"), "Milingo", "milingo@cobee.io"),
            new Manager(UUID.fromString("b7ba5e5e-950a-4e72-b048-4af3af9061a8"), "Jose", "jose@cobee.io"),
            new Manager(UUID.fromString("4072a708-4653-48da-ae6b-516f38bf163f"), "Paco", "paco@cobee.io")
    );
    when(this.findManagersUseCase.execute()).thenReturn(managers);
    assertEquals(3, findManagersController.find().spliterator().getExactSizeIfKnown());
  }

}
