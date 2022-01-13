package com.sk.projekat2.userservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.projekat2.userservice.domain.Manager;
import com.sk.projekat2.userservice.dto.ManagerCreateDto;
import com.sk.projekat2.userservice.dto.ManagerDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.exception.NotFoundException;
import com.sk.projekat2.userservice.mapper.ManagerMapper;
import com.sk.projekat2.userservice.repository.ManagerRepository;
import com.sk.projekat2.userservice.security.service.TokenService;
import com.sk.projekat2.userservice.service.ManagerService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
	
	private ManagerRepository managerRepository;
	private ManagerMapper managerMapper;
	private TokenService tokenService;
	
	public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper,
			TokenService tokenService) {
		this.managerRepository = managerRepository;
		this.managerMapper = managerMapper;
		this.tokenService = tokenService;
	}

	@Override
	public Page<ManagerDto> findAll(Pageable pageable) {
		return managerRepository.findAll(pageable)
				.map(managerMapper::managerToManagerDto);
	}

	@Override
	public ManagerDto add(ManagerCreateDto managerCreateDto) {
		Manager manager = managerMapper.managerCreateDtoToManager(managerCreateDto);
        managerRepository.save(manager);
        return managerMapper.managerToManagerDto(manager);
	}

	@Override
	public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
		Manager manager = managerRepository
				.findManagerByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
				.orElseThrow(() -> new NotFoundException(String
						.format("Manager with username: %s and password: %s not found", tokenRequestDto.getUsername(),
								tokenRequestDto.getPassword())));
			
			Claims claims = Jwts.claims();
			claims.put("id", manager.getId());
			claims.put("role", manager.getRole().getName());
			return new TokenResponseDto(tokenService.generate(claims));
	}

	@Override
	public ManagerDto findById(Long id) {
		Manager manager = managerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String
						.format("Manager with id: %d not found", id)));
		return managerMapper.managerToManagerDto(manager);
	}


}
