package br.com.fhsistemas.quizapp.dto;

import br.com.fhsistemas.quizapp.entity.question.Question.QuestionDifficulty;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionSaveRequest {

	protected Long id;
	protected QuestionType type;
	protected QuestionDifficulty difficulty;
	protected Long categoryId;
	private String question;
	private String explanation;
	
	private String correctAnswer;
	private String[] incorrectAnswers;

}
