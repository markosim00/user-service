package com.sk.projekat2.userservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.projekat2.userservice.domain.Client;
import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;
import com.sk.projekat2.userservice.dto.DiscountDto;
import com.sk.projekat2.userservice.dto.TokenRequestDto;
import com.sk.projekat2.userservice.dto.TokenResponseDto;
import com.sk.projekat2.userservice.exception.NotFoundException;
import com.sk.projekat2.userservice.mapper.ClientMapper;
import com.sk.projekat2.userservice.repository.ClientRepository;
import com.sk.projekat2.userservice.security.service.TokenService;
import com.sk.projekat2.userservice.service.ClientService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
	
	private ClientRepository clientRepository;
	private ClientMapper clientMapper;
	private TokenService tokenService;
	
	public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper, TokenService tokenService) {
		this.clientRepository = clientRepository;
		this.clientMapper = clientMapper;
		this.tokenService = tokenService;
	}

	@Override
	public Page<ClientDto> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable)
				.map(clientMapper::clientToClientDto);
	}

	@Override
	public ClientDto add(ClientCreateDto clientCreateDto) {
		Client client = clientMapper.clientCreateDtoToClient(clientCreateDto);
        clientRepository.save(client);
        return clientMapper.clientToClientDto(client);
	}

	@Override
	public ClientDto findById(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String
						.format("Client with id: %d not found", id)));
		return clientMapper.clientToClientDto(client);
	}

	@Override
	public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
		Client client = clientRepository
				.findClientByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
				.orElseThrow(() -> new NotFoundException(String
						.format("Client with username: %s and password: %s not found", tokenRequestDto.getUsername(),
								tokenRequestDto.getPassword())));
			
			Claims claims = Jwts.claims();
			claims.put("id", client.getId());
			claims.put("role", client.getRole().getName());
			return new TokenResponseDto(tokenService.generate(claims));
	}

	@Override
	public DiscountDto findDiscount(Long id) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String
						.format("Client with id: %d not found", id)));
		if(client.getNumberOfReservations() > 10 && client.getNumberOfReservations() < 20)
			return new DiscountDto(10);
		if(client.getNumberOfReservations() > 20)
			return new DiscountDto(20);
		return new DiscountDto(0);
	}

}
