package com.sk.projekat2.userservice.service.impl;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.projekat2.userservice.domain.Client;
import com.sk.projekat2.userservice.domain.User;
import com.sk.projekat2.userservice.dto.DiscountDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;
import com.sk.projekat2.userservice.exception.NotFoundException;
import com.sk.projekat2.userservice.mapper.UserMapper;
import com.sk.projekat2.userservice.repository.UserRepository;
import com.sk.projekat2.userservice.security.service.TokenService;
import com.sk.projekat2.userservice.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	private TokenService tokenService;
	
	public UserServiceImpl(UserRepository userRepository, TokenService tokenService, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
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

	@Override
	public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
		User user = userRepository
			.findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
			.orElseThrow(() -> new NotFoundException(String
					.format("User with username: %s and password: %s not found", tokenRequestDto.getUsername(),
							tokenRequestDto.getPassword())));
		
		Claims claims = Jwts.claims();
		claims.put("id", user.getId());
		claims.put("role", user.getRole().getName());
		return new TokenResponseDto(tokenService.generate(claims));
	}

	@Override
	public UserDto findById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String
						.format("User with id: %d not found", id)));
		return userMapper.userToUserDto(user);
	}

	

	
	
	

}
