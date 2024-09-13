package com.smes.smes;

import com.smes.smes.configs.MongoConfiguration;
import com.smes.smes.configs.PostgresConfiguration;
import com.smes.smes.configs.SmesApplicationConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest(classes = SmesApplicationConfiguration.class)
@EnableAutoConfiguration(exclude={MongoConfiguration.class, PostgresConfiguration.class})
public abstract class AbstractBaseUnitTest {
}