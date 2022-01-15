package com.sk.projekat2.userservice.controller;

import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.projekat2.userservice.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import com.sk.projekat2.userservice.dto.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping
	public ResponseEntity<Page<UserDto>> getAllUsers(Pageable pageable){
		return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserCreateDto userCreateDto){
		return new ResponseEntity<>(userService.add(userCreateDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginUser(@RequestBody @Valid TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }

}
