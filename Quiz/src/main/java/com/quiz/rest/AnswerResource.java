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

import com.quiz.model.Answer;
import com.quiz.model.Question;
import com.quiz.rest.dto.AnswerDTO;
import com.quiz.rest.dto.QuestionDTO;
import com.quiz.service.AnswerService;
import com.quiz.service.QuestionService;


@RestController
@RequestMapping("/api/answer")
public class AnswerResource {
	
	@Autowired
	AnswerService answerService;
	
		@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public  ResponseEntity<?> addAnswer(@RequestBody AnswerDTO answerDTO) {
			Answer answer = answerService.saveAnswer(answerDTO);
			
			return new ResponseEntity<>(answer, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		@ResponseBody
		public ResponseEntity<?> deleteAnswer(@PathVariable final Long id) {
			answerService.deleteAnswer(id);
			return ResponseEntity.ok("The question was succesfully deleted!");
		}
		
		@RequestMapping(value = "update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> updateAnswer(@PathVariable final long id, @RequestBody  final AnswerDTO answerDTO, BindingResult result) {
					
			Answer answer = answerService.updateAnswer(id, answerDTO);
			return new ResponseEntity<>(answer, HttpStatus.OK);

		}

}
