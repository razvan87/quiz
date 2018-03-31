package com.quiz.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quiz.model.Answer;
import com.quiz.model.Question;
import com.quiz.rest.dto.QuestionDTO;

@Component
public class QuestionConverter {
	
	public Question toEntity(QuestionDTO questionDTO, Question question) {
		question.setTheQuestion(questionDTO.getTheQuestion());
		question.setProgrammingLanguage(questionDTO.getProgrammingLanguage());
		question.setQuestionLevel(questionDTO.getQuestionLevel());
		question.setPoints(questionDTO.getPoints());
		return question;
		
	}
	
	public QuestionDTO toDTO(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setProgrammingLanguage(question.getProgrammingLanguage());
		questionDTO.setTheQuestion(question.getTheQuestion());
		questionDTO.setQuestionLevel(question.getQuestionLevel());
		questionDTO.setPoints(question.getPoints());
		
		
		return questionDTO;
	}
	
	public List<QuestionDTO> fromObjectToDTO(Object[] item) {
		List<QuestionDTO> QuestionsDTO = new ArrayList<>();
		
			for(int i = 0; i<item.length; i++) {
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setTheQuestion(item[i].toString());
				questionDTO.setQuestionLevel((Integer)item[1]);
				questionDTO.setPoints((Integer)item[1]);
				QuestionsDTO.add(questionDTO);
			}
		
		return QuestionsDTO;
	}

}
