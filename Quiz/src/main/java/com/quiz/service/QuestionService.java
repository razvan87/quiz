package com.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.converter.QuestionConverter;
import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import com.quiz.rest.dto.QuestionDTO;
import com.quiz.service.errors.ResourceNotFoundException;

@Service
public class QuestionService {
	
	@Autowired
	QuestionConverter questionConverter;
	
	@Autowired
	QuestionRepository questionRepository;
	
	public Question saveQuestion(QuestionDTO questionDTO) {
		Question question = new Question(); 
		question = questionConverter.toEntity(questionDTO, question);
		questionRepository.save(question);
		return question;
	}
	
	public void deleteQuestion(long id) {
		questionRepository.delete(id);
	}

	public Question updateQuestion(long id, QuestionDTO questionDTO) {
		Question question = questionRepository.findOne(id);
//        if (question == null) {
//            throw new ResourceNotFoundException("Question not found for update!", "question.not.found", id);
//        }
//        question = questionConverter.toEntity(questionDTO, question);
        return questionRepository.saveAndFlush(question);
    }
	
	
	public List<QuestionDTO> getAll() {
		List<Question> questions = questionRepository.findAll();
		List<QuestionDTO> questionsDTO = new ArrayList<>();
		for (Question question: questions) {
			 QuestionDTO questionDTO = questionConverter.toDTO(question);
			 questionsDTO.add(questionDTO);
		}
		return questionsDTO;
	}
	
	public List<Object[]> getAllByLanguageId(Long id) {
		List<Object[]> questions = questionRepository.findAllByLanguageId(id);
//		List<QuestionDTO> questionsDTO = new ArrayList<>();
//		for (Object[] item: questions) {
//			 QuestionDTO questionDTO = questionConverter.fromObjectToDTO(item);
//			 questionsDTO.add(questionDTO);
//		}
		return questions;
	}
	
	public QuestionDTO findOne(Long id) {
		Question question = questionRepository.findOne(id);
		QuestionDTO questionDTO = questionConverter.toDTO(question);
		return questionDTO;
	}
	
}
