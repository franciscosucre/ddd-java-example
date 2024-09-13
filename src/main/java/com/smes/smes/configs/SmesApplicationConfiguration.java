package com.smes.smes.configs;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.MongoManagersRepository;
import com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository.SpringManagerRepository;
import com.smes.smes.application.usecases.CreateManagerUseCase;
import com.smes.smes.application.usecases.RemoveManagerUseCase;
import com.smes.smes.application.usecases.UpdateManagerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smes.smes.domain.repositories.ManagersRepository;
import com.smes.smes.application.usecases.FindManagersUseCase;
import com.smes.smes.adapters.out.persistance.repositories.InMemoryManagersRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

import javax.swing.*;

@Configuration
public class SmesApplicationConfiguration {

    @Autowired
    public MongoTemplate mongoTemplate;

    @Autowired
    public SpringManagerRepository springManagerRepository;


    @Bean
    public ManagersRepository managersRepository() throws Exception {
        return new MongoManagersRepository(this.springManagerRepository);
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
