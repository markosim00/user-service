package com.sk.projekat2.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.projekat2.userservice.dto.ManagerCreateDto;
import com.sk.projekat2.userservice.dto.ManagerDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;

public interface ManagerService {
	
	Page<ManagerDto> findAll(Pageable pageable);
	
	ManagerDto add(ManagerCreateDto managerCreateDto);
	
	TokenResponseDto login(TokenRequestDto tokenRequestDto);
	
	ManagerDto findById(Long id);

}
