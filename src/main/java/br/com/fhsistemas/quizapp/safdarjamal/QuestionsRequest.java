package br.com.fhsistemas.quizapp.safdarjamal;

import br.com.fhsistemas.quizapp.entity.question.Question.QuestionDifficulty;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsRequest {
	protected Long amount;
	protected Long category;
	protected QuestionDifficulty difficulty;
	protected QuestionType type;
}
