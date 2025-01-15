package br.com.fhsistemas.quizapp.entity.book;

import br.com.fhsistemas.quizapp.entity.question.QuestionBoolean;
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
public class BookQuestionBoolean extends BookQuestion {

	private static final long serialVersionUID = -190532320009937699L;
	@Column(nullable = true, insertable = true, updatable = true)
	protected Boolean answer;

	@Override
	protected Boolean isCorrect() {
		return ((QuestionBoolean) this.question).getCorrectAnswer().equals(answer);
	}
}
