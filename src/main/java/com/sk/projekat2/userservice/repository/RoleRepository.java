package com.sk.projekat2.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.projekat2.userservice.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findRoleByName(String name);

}
