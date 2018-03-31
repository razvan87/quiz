package com.quiz.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Question;
import com.quiz.rest.dto.QuestionDTO;

import com.quiz.service.QuestionService;


@RestController
@RequestMapping("/api/question")
public class QuestionResource {
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<?> addQuestion(@RequestBody QuestionDTO questionDTO) {
		Question question = questionService.saveQuestion(questionDTO);
		
		return new ResponseEntity<>(question, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@ResponseBody
	public ResponseEntity<?> deleteQuestion(@PathVariable final Long id) {
		questionService.deleteQuestion(id);
		return ResponseEntity.ok("The question was succesfully deleted!");
	}
	
	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateQuestion(@PathVariable final long id, @RequestBody  final QuestionDTO questionDTO, BindingResult result) {
				
		Question question = questionService.updateQuestion(id, questionDTO);
		return new ResponseEntity<>(question, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll() {
		List<QuestionDTO> questionsDTO = questionService.getAll();
		return new ResponseEntity<>(questionsDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getAllByLanguage", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(@PathVariable final Long id) {
		List<Object[]> questionsDTO = questionService.getAllByLanguageId(id);
		return new ResponseEntity<>(questionsDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getQuestion/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getQuestion(@PathVariable final Long id) {
		QuestionDTO questionDTO = questionService.findOne(id);
		return new ResponseEntity<>(questionDTO, HttpStatus.OK);
		
	}
}
