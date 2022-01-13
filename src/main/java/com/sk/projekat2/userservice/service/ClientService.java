package com.sk.projekat2.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;
import com.sk.projekat2.userservice.dto.DiscountDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;



public interface ClientService {
	
	Page<ClientDto> findAll(Pageable pageable);
	
	ClientDto add(ClientCreateDto clientCreateDto);
	
	TokenResponseDto login(TokenRequestDto tokenRequestDto);
	
	ClientDto findById(Long id);
	
	DiscountDto findDiscount(Long id);

}
