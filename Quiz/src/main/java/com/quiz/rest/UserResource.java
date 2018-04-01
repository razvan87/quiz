package com.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Question;
import com.quiz.model.User;
import com.quiz.rest.dto.QuestionDTO;
import com.quiz.rest.dto.UserDTO;
import com.quiz.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<?> addQuestion(@RequestBody UserDTO userDTO) {
		User user = userService.saveUser(userDTO);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody
	public ResponseEntity<?> deleteQuestion(@PathVariable final Long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok("The question was succesfully deleted!");
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateQuestion(@PathVariable final long id, @RequestBody  final UserDTO userDTO, BindingResult result) {
				
		User user = userService.updateUser(id, userDTO);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	

}
