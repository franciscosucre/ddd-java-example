package com.smes.smes.adapters.out.persistance.repositories.mongo_managers_repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoManagerRepository extends MongoRepository<ManagerMongoDatabaseEntity, String> {

}
