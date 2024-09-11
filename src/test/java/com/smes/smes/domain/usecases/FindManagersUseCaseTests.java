package com.smes.smes.domain.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.smes.smes.domain.entities.Manager;
import com.smes.smes.domain.repositories.ManagersRepository;

@SpringBootTest
class FindManagersUseCaseTests {

  @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(FindManagersUseCaseTests.class);
    }

  @InjectMocks
  FindManagersUseCase findManagersUseCase;


  @Mock
  ManagersRepository managersRepository;


  @Test
  void shouldReturnAllManagers() {
    List<Manager> managers = List.of(
            new Manager(UUID.fromString("14e966b9-ab1d-45d0-aab9-10c3b4e4e771"), "Milingo", "milingo@cobee.io"),
            new Manager(UUID.fromString("b7ba5e5e-950a-4e72-b048-4af3af9061a8"), "Jose", "jose@cobee.io"),
            new Manager(UUID.fromString("4072a708-4653-48da-ae6b-516f38bf163f"), "Paco", "paco@cobee.io")
    );
    when(this.managersRepository.find()).thenReturn(managers);
    assertEquals(3, findManagersUseCase.execute().spliterator().getExactSizeIfKnown());
  }

}
