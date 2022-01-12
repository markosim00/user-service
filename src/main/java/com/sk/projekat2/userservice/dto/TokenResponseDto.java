package com.sk.projekat2.userservice.dto;

public class TokenResponseDto {
	
	String token;
	
	public TokenResponseDto() {
		
	}
	
	public TokenResponseDto(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
