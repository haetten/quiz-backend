package br.com.fhsistemas.quizapp.entity.question;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@DiscriminatorValue("BOOLEAN")
public class QuestionBoolean extends Question {

	private static final long serialVersionUID = -8861184380711448258L;
	
	@Column(name = "correct_answer_boolean", nullable = true, insertable = true, updatable = true)
	protected Boolean correctAnswer = Boolean.FALSE;

	@Override
	public String getCorrectAnswerString() {
		return Boolean.toString(getCorrectAnswer());
	}

	@Override
	public List<String> getIncorrectAnswersString() {
		return List.of(Boolean.toString(!getCorrectAnswer()));
	}

	
}