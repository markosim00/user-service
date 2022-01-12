package com.sk.projekat2.userservice.security.service;

import io.jsonwebtoken.Claims;

public interface TokenService {
	
	String generate(Claims claims);
	
	Claims parseToken(String jwt);

}
