package br.com.fhsistemas.quizapp.safdarjamal;

import java.util.List;

import br.com.fhsistemas.quizapp.entity.question.Question;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionDifficulty;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
	protected QuestionType type;
	protected QuestionDifficulty difficulty;
	protected String discipline;
	protected String category;
	protected String question;
	protected String correct_answer;
	protected List<String> incorrect_answers;
	protected String explanation;

	
	public QuestionDTO(Question question) {
		super();
		this.type = question.getType();
		if(question.getCategory() != null &&  question.getCategory().getDiscipline() != null) {
			this.discipline = question.getCategory().getDiscipline().getName();
		}
		this.category = question.getCategory().getFullName();
		this.question = question.getQuestion();
		this.explanation = question.getExplanation();
		this.difficulty = question.getDifficulty();

		this.correct_answer = question.getCorrectAnswerString();
		this.incorrect_answers = question.getIncorrectAnswersString();

	}

	
}
