package com.sk.projekat2.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.projekat2.userservice.domain.*;

public interface ManagerRepository extends JpaRepository<Manager, Long>{
	
	Optional<User> findUserByUsernameAndPassword(String username, String password);

}
