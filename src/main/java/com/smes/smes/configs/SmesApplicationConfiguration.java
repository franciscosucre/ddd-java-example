package com.smes.smes.configs;


import com.smes.smes.application.usecases.CreateManagerUseCase;
import com.smes.smes.application.usecases.RemoveManagerUseCase;
import com.smes.smes.application.usecases.UpdateManagerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smes.smes.domain.repositories.ManagersRepository;
import com.smes.smes.application.usecases.FindManagersUseCase;
import com.smes.smes.adapters.out.persistance.repositories.InMemoryManagersRepository;

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
