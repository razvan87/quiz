package com.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.converter.UserConverter;
import com.quiz.model.Question;
import com.quiz.model.User;
import com.quiz.repository.UserRepository;
import com.quiz.rest.dto.QuestionDTO;
import com.quiz.rest.dto.UserDTO;

@Service
@Transactional
public class UserService {
  
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	public User saveUser(UserDTO userDTO) {
		User user = new User();
		user = userConverter.toEntity(userDTO, user);
		userRepository.save(user);
		return user;
	}
	
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
	
	
	public User updateUser(Long id, UserDTO userDTO) {
		User user = userRepository.findOne(id);
//        if (question == null) {
//            throw new ResourceNotFoundException("Question not found for update!", "question.not.found", id);
//        }
		user = userConverter.toEntity(userDTO, user);
        return userRepository.saveAndFlush(user);
    }
}
