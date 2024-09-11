package com.smes.smes.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smes.smes.domain.repositories.ManagersRepository;
import com.smes.smes.domain.usecases.FindManagersUseCase;
import com.smes.smes.infrastructure.repositories.InMemoryManagersRepository;

@Configuration
public class SmesApplicationConfiguration {

    @Bean
    public ManagersRepository managersRepository() {
        return new InMemoryManagersRepository();
    }

    @Bean
    public FindManagersUseCase findManagersUseCase() {
        return new FindManagersUseCase(this.managersRepository());
    }

}
