package com.smes.smes.infrastructure.repositories.mongo_managers_repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringManagerRepository extends MongoRepository<ManagerDatabaseEntity, String> {

}
