package com.sha.microserviceusermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sha.microserviceusermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	@Query("Select u.name from User u where u.id in (:pIdList)")
	List<String> findUserNames(@Param("pIdList") List<Long> idList);
}
	