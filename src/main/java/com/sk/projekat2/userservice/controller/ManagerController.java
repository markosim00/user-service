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

import com.sk.projekat2.userservice.dto.ManagerCreateDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;
import com.sk.projekat2.userservice.service.UserService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	private UserService userService;

	public ManagerController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<Page<UserDto>> getAllManagers(Pageable pageable){
		return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getManagerById(@PathVariable("id") Long id){
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<UserDto> saveManager(@RequestBody ManagerCreateDto managerCreateDto){
		return new ResponseEntity<>(userService.add(managerCreateDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginManager(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(userService.login(tokenRequestDto), HttpStatus.OK);
    }
	
	
	
	

}
