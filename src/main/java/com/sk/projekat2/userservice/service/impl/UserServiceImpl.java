package com.sk.projekat2.userservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.projekat2.userservice.domain.User;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;
import com.sk.projekat2.userservice.mapper.UserMapper;
import com.sk.projekat2.userservice.repository.UserRepository;
import com.sk.projekat2.userservice.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public Page<UserDto> findAll(Pageable pageable) {
		return userRepository.findAll(pageable)
				.map(userMapper::userToUserDto);
	}

	@Override
	public UserDto add(UserCreateDto userCreateDto) {
		User user = userMapper.userCreateDtoToUser(userCreateDto);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
	}
	
	

}
