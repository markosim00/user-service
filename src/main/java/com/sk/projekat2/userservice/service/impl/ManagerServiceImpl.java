package com.sk.projekat2.userservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;
import com.sk.projekat2.userservice.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	@Override
	public Page<ClientDto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDto add(ClientCreateDto clientCreateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
