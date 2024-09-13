package com.smes.smes.configs;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.smes.smes.adapters.out.persistance.repositories")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment env;


    @Override
    public String getDatabaseName() {
        return "test";
    }

    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        // customization hook
        builder.applyConnectionString(new ConnectionString(env.getProperty("spring.data.mongodb.uri")));
    }


}
