package com.smes.smes.adapters.out.persistance.repositories;

import com.smes.smes.helpers.test_types.AbstractBaseIntegrationTest;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.ManagerMongoDatabaseEntity;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.MongoManagersRepository;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.SpringMongoManagerRepository;
import com.smes.smes.domain.entities.Manager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@Import(MongoManagersRepository.class)
class MongoManagersRepositoryTests extends AbstractBaseIntegrationTest {

    @Autowired
    MongoManagersRepository mongoManagersRepository;

    @Autowired
    SpringMongoManagerRepository springMongoManagerRepository;


    @Test
    void shouldReturnNoManagers() {
        List<Manager> managers = this.mongoManagersRepository.find();
        assertEquals(0, managers.spliterator().getExactSizeIfKnown());
    }

    @Test
    void shouldReturnTwoManagers() {

        this.springMongoManagerRepository.save(
                new ManagerMongoDatabaseEntity(
                        UUID.fromString("0a18144c-aedb-4992-a2b5-5f6781a6db54"),
                        "Test 1",
                        "test1@test.io"
                )
        );
        this.springMongoManagerRepository.save(
                new ManagerMongoDatabaseEntity(
                        UUID.fromString("112d92ed-1492-471a-b947-83a7f358af4b"),
                        "Test 2",
                        "test2@test.io"
                )
        );

        List<Manager> managers = this.mongoManagersRepository.find();
        assertEquals(2, managers.spliterator().getExactSizeIfKnown());
    }

}
