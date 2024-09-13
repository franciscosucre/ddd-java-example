package com.smes.smes;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;


public abstract class AbstractBaseIntegrationTest {


    @DynamicPropertySource
    static void containersProperties(DynamicPropertyRegistry registry) {
        MongoDbSingletonContainer.containersProperties(registry);
        PostgresSingletonContainer.containersProperties(registry);
    }

    static {
        MongoDbSingletonContainer.start();
        PostgresSingletonContainer.start();
    }


}