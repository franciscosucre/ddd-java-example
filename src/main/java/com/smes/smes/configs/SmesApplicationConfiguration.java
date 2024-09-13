package com.smes.smes.configs;


import com.smes.smes.adapters.out.persistance.repositories.InMemoryManagersRepository;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.MongoManagersRepository;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.SpringMongoManagerRepository;
import com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository.PostgresManagersRepository;
import com.smes.smes.adapters.out.persistance.repositories.postgres_managers_repository.SpringPostgresManagerRepository;
import com.smes.smes.application.usecases.CreateManagerUseCase;
import com.smes.smes.application.usecases.RemoveManagerUseCase;
import com.smes.smes.application.usecases.UpdateManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smes.smes.domain.repositories.ManagersRepository;
import com.smes.smes.application.usecases.FindManagersUseCase;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SmesApplicationConfiguration {

    @Autowired
    public SpringMongoManagerRepository springMongoManagerRepository;

    @Autowired
    public SpringPostgresManagerRepository springPostgresManagerRepository;


    @Bean
    public MongoManagersRepository mongoManagersRepository() throws Exception {
        return new MongoManagersRepository(this.springMongoManagerRepository);
    }

    @Bean
    public PostgresManagersRepository postgresManagersRepository() throws Exception {
        return new PostgresManagersRepository(this.springPostgresManagerRepository);
    }

    @Bean
    public ManagersRepository managersRepository() throws Exception {
        return new InMemoryManagersRepository();
    }

    @Bean
    public FindManagersUseCase findManagersUseCase() throws Exception {
        return new FindManagersUseCase(this.managersRepository());
    }

    @Bean
    public CreateManagerUseCase createManagerUseCase() throws Exception {
        return new CreateManagerUseCase(this.managersRepository());
    }

    @Bean
    public UpdateManagerUseCase updateManagerUseCase() throws Exception {
        return new UpdateManagerUseCase(this.managersRepository());
    }

    @Bean
    public RemoveManagerUseCase removeManagerUseCase() throws Exception {
        return new RemoveManagerUseCase(this.managersRepository());
    }
}
