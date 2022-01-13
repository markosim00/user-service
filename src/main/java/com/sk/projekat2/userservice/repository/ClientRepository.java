package com.sk.projekat2.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.projekat2.userservice.domain.*;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Optional<Client> findClientByUsernameAndPassword(String username, String password);
}
