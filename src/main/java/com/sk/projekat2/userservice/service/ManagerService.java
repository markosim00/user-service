package com.sk.projekat2.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;

public interface ManagerService {
	
	Page<ClientDto> findAll(Pageable pageable);
	
	ClientDto add(ClientCreateDto clientCreateDto);
	
	ClientDto findById(Long id);

}
