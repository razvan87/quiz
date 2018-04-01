package com.quiz.converter;

import org.springframework.stereotype.Component;

import com.quiz.model.User;
import com.quiz.rest.dto.UserDTO;

@Component
public class UserConverter {
	
	public User toEntity(UserDTO userDTO, User user) {
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUserName());
		user.setUserType(userDTO.getUserType());
		user.setPassword(userDTO.getPassword());
		
		return user;
	}

}
