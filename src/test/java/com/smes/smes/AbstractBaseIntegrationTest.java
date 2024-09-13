package com.smes.smes;

import com.smes.smes.configs.SmesApplicationConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(classes = SmesApplicationConfiguration.class)
public abstract class AbstractBaseIntegrationTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @ServiceConnection
    public static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0").withReuse(true);
    @ServiceConnection
    public static final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine")).withReuse(true);

    @DynamicPropertySource
    static void containersProperties(DynamicPropertyRegistry registry) {

        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        registry.add("spring.data.mongodb.host", mongoDBContainer::getHost);
        registry.add("spring.data.mongodb.port", mongoDBContainer::getFirstMappedPort);
        registry.add("spring.data.mongodb.database", () -> "testdb");

        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    static {
        mongoDBContainer.start();
        postgreSQLContainer.start();
    }

    @AfterEach()
    public void afterEach(){
        mongoTemplate.getDb().drop();
    }


}