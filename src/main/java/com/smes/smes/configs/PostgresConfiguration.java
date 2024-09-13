package com.smes.smes.configs;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.smes.smes.adapters.out.persistance.repositories.postgres_*")
public class PostgresConfiguration {


}
