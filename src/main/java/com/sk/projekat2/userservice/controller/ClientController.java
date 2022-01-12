package com.sk.projekat2.userservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;
import com.sk.projekat2.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class ClientController {
	
	private UserService userService;

	public ClientController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<Page<UserDto>> getAllClients(Pageable pageable){
		return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<UserDto> saveClient(@RequestBody UserCreateDto userCreateDto){
		return new ResponseEntity<>(userService.add(userCreateDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginClient(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }
	
	

}
