package com.smes.smes.configs;


import com.smes.smes.domain.usecases.CreateManagerUseCase;
import com.smes.smes.domain.usecases.RemoveManagerUseCase;
import com.smes.smes.domain.usecases.UpdateManagerUseCase;
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

    @Bean
    public CreateManagerUseCase createManagerUseCase() {
        return new CreateManagerUseCase(this.managersRepository());
    }

    @Bean
    public UpdateManagerUseCase updateManagerUseCase() {
        return new UpdateManagerUseCase(this.managersRepository());
    }

    @Bean
    public RemoveManagerUseCase removeManagerUseCase() {
        return new RemoveManagerUseCase(this.managersRepository());
    }
}
