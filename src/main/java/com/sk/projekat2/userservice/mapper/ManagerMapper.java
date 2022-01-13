package com.sk.projekat2.userservice.mapper;

import org.springframework.stereotype.Component;

import com.sk.projekat2.userservice.domain.Manager;
import com.sk.projekat2.userservice.dto.ManagerCreateDto;
import com.sk.projekat2.userservice.dto.ManagerDto;
import com.sk.projekat2.userservice.repository.RoleRepository;

@Component
public class ManagerMapper {
	
private RoleRepository roleRepository;
	
	public ManagerMapper(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public ManagerDto managerToManagerDto(Manager manager) {
        ManagerDto managerDto = new ManagerDto();
        managerDto.setId(manager.getId());
        managerDto.setEmail(manager.getEmail());
        managerDto.setFirstName(manager.getFirstName());
        managerDto.setLastName(manager.getLastName());
        managerDto.setUsername(manager.getUsername());
        return managerDto;
    }
	
	public Manager managerCreateDtoToManager(ManagerCreateDto managerCreateDto) {
		
		Manager manager = new Manager();
        manager.setEmail(managerCreateDto.getEmail());
        manager.setFirstName(managerCreateDto.getFirstName());
        manager.setLastName(managerCreateDto.getLastName());
        manager.setUsername(managerCreateDto.getUsername());
        manager.setPassword(managerCreateDto.getPassword());
        manager.setContact(managerCreateDto.getContact());
        manager.setBirthDate(managerCreateDto.getBirthDate());
        manager.setHotelName(managerCreateDto.getHotelName());
        manager.setDateOfEmployment(managerCreateDto.getDateOfEmployment());
        manager.setRole(roleRepository.findRoleByName("ROLE_MANAGER").get());
        
        return manager;
	}

}
