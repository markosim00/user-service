package com.sk.projekat2.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.projekat2.userservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
		Optional<User> findUserByUsernameAndPassword(String username, String password);

}
