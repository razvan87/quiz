package com.quiz.rest.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.quiz.model.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class AnswerDTO {

    private String name;
	
	private boolean isCorrect;
	
	
	private Question idQuestion;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isCorrect() {
		return isCorrect;
	}


	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	public Question getIdQuestion() {
		return idQuestion;
	}


	public void setIdQuestion(Question idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
}
