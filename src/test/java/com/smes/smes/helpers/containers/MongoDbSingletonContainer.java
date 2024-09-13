package com.smes.smes.helpers.containers;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.MongoDBContainer;

public class MongoDbSingletonContainer extends AbstractDatabaseContainer {
    @ServiceConnection
    protected static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0");

    public static void start() {
        mongoDBContainer.start();
    }

    public static void containersProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        registry.add("spring.data.mongodb.host", mongoDBContainer::getHost);
        registry.add("spring.data.mongodb.port", mongoDBContainer::getFirstMappedPort);
        registry.add("spring.data.mongodb.database", () -> "testdb");
    }
}