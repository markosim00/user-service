package com.sk.projekat2.userservice.mapper;

import org.springframework.stereotype.Component;

import com.sk.projekat2.userservice.domain.Client;
import com.sk.projekat2.userservice.domain.User;
import com.sk.projekat2.userservice.dto.ClientCreateDto;
import com.sk.projekat2.userservice.dto.ClientDto;
import com.sk.projekat2.userservice.dto.UserCreateDto;
import com.sk.projekat2.userservice.dto.UserDto;
import com.sk.projekat2.userservice.repository.RoleRepository;

@Component
public class ClientMapper {
	
	private RoleRepository roleRepository;
	
	public ClientMapper(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public ClientDto clientToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setEmail(client.getEmail());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setUsername(client.getUsername());
        return clientDto;
    }
	
	public Client clientCreateDtoToClient(ClientCreateDto clientCreateDto) {
		
		Client client = new Client();
        client.setEmail(clientCreateDto.getEmail());
        client.setFirstName(clientCreateDto.getFirstName());
        client.setLastName(clientCreateDto.getLastName());
        client.setUsername(clientCreateDto.getUsername());
        client.setPassword(clientCreateDto.getPassword());
        client.setContact(clientCreateDto.getContact());
        client.setBirthDate(clientCreateDto.getBirthDate());
        client.setPassportNumber(clientCreateDto.getPassportNumber());
        client.setNumberOfReservations(clientCreateDto.getNumberOfReservations());
        client.setRole(roleRepository.findRoleByName("ROLE_CLIENT").get());
        
        return client;
	}

}
