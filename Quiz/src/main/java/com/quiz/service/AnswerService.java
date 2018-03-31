package com.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.converter.AnswerConverter;
import com.quiz.model.Answer;
import com.quiz.repository.AnswerRepository;
import com.quiz.rest.dto.AnswerDTO;


@Service
public class AnswerService {
	
	@Autowired
	AnswerConverter answerConverter;
	
	@Autowired
	AnswerRepository answerRepository;
	
	public Answer saveAnswer(AnswerDTO answerDTO) {
		Answer answer = new Answer(); 
		answer = answerConverter.toEntity(answerDTO, answer);
		answerRepository.save(answer);
		return answer;
	}
	
	public void deleteAnswer(long id) {
		answerRepository.delete(id);
	}

	public Answer updateAnswer(long id, AnswerDTO answerDTO) {
		Answer answer = answerRepository.findOne(id);
//        if (question == null) {
//            throw new ResourceNotFoundException("Question not found for update!", "question.not.found", id);
//        }
//        question = questionConverter.toEntity(questionDTO, question);
        return answerRepository.saveAndFlush(answer);
    }

}
