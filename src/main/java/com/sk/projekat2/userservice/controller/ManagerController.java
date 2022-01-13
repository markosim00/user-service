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

import com.sk.projekat2.userservice.dto.ManagerCreateDto;
import com.sk.projekat2.userservice.dto.ManagerDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	private ManagerService managerService;

	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@GetMapping
	public ResponseEntity<Page<ManagerDto>> getAllManagers(Pageable pageable){
		return new ResponseEntity<>(managerService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ManagerDto> getManagerById(@PathVariable("id") Long id){
		return new ResponseEntity<>(managerService.findById(id), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<ManagerDto> saveManager(@RequestBody ManagerCreateDto managerCreateDto){
		return new ResponseEntity<>(managerService.add(managerCreateDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginManager(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(managerService.login(tokenRequestDto), HttpStatus.OK);
    }
	
	
	
	

}
