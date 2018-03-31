package com.quiz.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	@Query(nativeQuery = true, value= "SELECT questions.the_question, questions.question_level, questions.points, answers.name, answers.is_correct, programming_language.name FROM questions INNER JOIN answers ON questions.id_question = answers.id_question INNER JOIN programming_language ON programming_language.id = questions.id_programming_language WHERE programming_language.id = :id")
	List<Object[]> findAllByLanguageId(@Param("id") Long id); 

}
