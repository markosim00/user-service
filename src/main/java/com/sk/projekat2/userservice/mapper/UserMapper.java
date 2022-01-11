package com.sk.projekat2.userservice.mapper;

import org.springframework.stereotype.Component;

import com.sk.projekat2.userservice.domain.User;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;
import com.sk.projekat2.userservice.repository.RoleRepository;

@Component
public class UserMapper {
	
	private RoleRepository roleRepository;
	
	public UserMapper(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        return userDto;
    }
	
	public User userCreateDtoToUser(UserCreateDto userCreateDto) {
		
		User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setContact(userCreateDto.getContact());
        user.setBirthDate(userCreateDto.getBirthDate());
        user.setRole(roleRepository.findRoleByName("ROLE_USER").get());
        
        return user;
	}

}
