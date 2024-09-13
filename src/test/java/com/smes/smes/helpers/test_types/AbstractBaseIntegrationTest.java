package com.smes.smes.helpers.test_types;

import com.smes.smes.helpers.containers.MongoDbSingletonContainer;
import com.smes.smes.helpers.containers.PostgresSingletonContainer;
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