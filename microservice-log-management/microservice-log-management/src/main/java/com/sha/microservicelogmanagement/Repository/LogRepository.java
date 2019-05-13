package com.sha.microservicelogmanagement.Repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.sha.microservicelogmanagement.model.Log;

public interface LogRepository extends CrudRepository<Log, UUID> {

}
