package com.quiz.rest.dto;

import com.quiz.model.Answer;
import com.quiz.model.ProgrammingLanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class QuestionDTO {
	
    private String theQuestion;
	
	private ProgrammingLanguage programmingLanguage;
	
	private int questionLevel;
	
	private int points;
	
	private Answer answer;

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public String getTheQuestion() {
		return theQuestion;
	}

	public void setTheQuestion(String theQuestion) {
		this.theQuestion = theQuestion;
	}

	public ProgrammingLanguage getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public int getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
