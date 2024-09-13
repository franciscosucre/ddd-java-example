package com.smes.smes;

import com.smes.smes.configs.MongoConfiguration;
import com.smes.smes.configs.PostgresConfiguration;
import com.smes.smes.configs.SmesApplicationConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SmesApplicationConfiguration.class)
@EnableAutoConfiguration(exclude={MongoConfiguration.class, PostgresConfiguration.class})
public abstract class AbstractBaseUnitTest {
}