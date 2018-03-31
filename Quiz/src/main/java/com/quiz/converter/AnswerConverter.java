package com.quiz.converter;

import org.springframework.stereotype.Component;

import com.quiz.model.Answer;
import com.quiz.rest.dto.AnswerDTO;

@Component
public class AnswerConverter {
	
	public Answer toEntity(AnswerDTO answerDTO, Answer answer) {
		
		answer.setAnsweName(answerDTO.getName());
		answer.setCorrectAnswer(answerDTO.isCorrect());
		return answer;
		
	}

}
