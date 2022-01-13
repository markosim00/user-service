package com.sk.projekat2.userservice.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.sk.projekat2.userservice.domain.Role;
import com.sk.projekat2.userservice.domain.User;
import com.sk.projekat2.userservice.repository.RoleRepository;
import com.sk.projekat2.userservice.repository.UserRepository;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner{
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	public TestDataRunner(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Role roleClient = new Role("ROLE_CLIENT", "Client role");
		Role roleManager = new Role("ROLE_MANAGER", "Manager role");
		Role roleAdmin = new Role("ROLE_ADMIN", "Admin role");
		roleRepository.save(roleClient);
		roleRepository.save(roleManager);
		roleRepository.save(roleAdmin);
		
		User admin = new User();
		admin.setEmail("admin@gmail.com");
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setRole(roleAdmin);
		userRepository.save(admin);
	}

}
