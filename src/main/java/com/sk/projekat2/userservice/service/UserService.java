package com.sk.projekat2.userservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sk.projekat2.userservice.dto.*;

public interface UserService {
	
	Page<UserDto> findAll(Pageable pageable);
	
	UserDto add(UserCreateDto userCreateDto);

}
