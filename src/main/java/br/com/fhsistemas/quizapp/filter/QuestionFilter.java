package br.com.fhsistemas.quizapp.filter;

import br.com.fhsistemas.quizapp.entity.question.Question.QuestionDifficulty;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionType;
import br.com.fhsistemas.quizapp.generic.model.GenericFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class QuestionFilter extends GenericFilter{
	Long category; 
	QuestionDifficulty difficulty; 
	QuestionType type;
	String question;
	
	public QuestionFilter(Integer pageSize, 
						  Long category, QuestionDifficulty difficulty, QuestionType type, String question) {
		super(1, pageSize, "RANDom()");
		this.category = category;
		this.difficulty = difficulty;
		this.type = type;
		this.question = question;
	}
	
	
}
