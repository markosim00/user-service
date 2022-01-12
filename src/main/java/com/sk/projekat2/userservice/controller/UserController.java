package com.sk.projekat2.userservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.projekat2.userservice.service.UserService;
import com.sk.projekat2.userservice.dto.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<Page<UserDto>> getAllUsers(Pageable pageable){
		return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody UserCreateDto userCreateDto){
		return new ResponseEntity<>(userService.add(userCreateDto), HttpStatus.CREATED);
	}

}
