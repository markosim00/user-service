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

import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;
import com.sk.projekat2.userservice.dto.DiscountDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.service.ClientService;

@RestController
@RequestMapping("/user")
public class ClientController {
	
	private ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientDto>> getAllClients(Pageable pageable){
		return new ResponseEntity<>(clientService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDto> getClientById(@PathVariable("id") Long id){
		return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/discount")
    public ResponseEntity<DiscountDto> getDiscount(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clientService.findDiscount(id), HttpStatus.OK);
    }
	
	@PostMapping
	public ResponseEntity<ClientDto> saveClient(@RequestBody ClientCreateDto clientCreateDto){
		return new ResponseEntity<>(clientService.add(clientCreateDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
    public ResponseEntity<TokenResponseDto> loginClient(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(clientService.login(tokenRequestDto), HttpStatus.OK);
    }
	
	

}
