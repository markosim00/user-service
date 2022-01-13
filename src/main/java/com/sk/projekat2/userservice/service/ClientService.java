package com.sk.projekat2.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;


public interface ClientService {
	
	Page<ClientDto> findAll(Pageable pageable);
	
	ClientDto add(ClientCreateDto clientCreateDto);
	
	TokenResponseDto login(TokenRequestDto tokenRequestDto);
	
	ClientDto findById(Long id);

}
