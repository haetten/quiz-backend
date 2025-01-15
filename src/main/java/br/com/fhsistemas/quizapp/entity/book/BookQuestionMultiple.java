package br.com.fhsistemas.quizapp.entity.book;

import br.com.fhsistemas.quizapp.entity.question.IncorrectAnswer;
import br.com.fhsistemas.quizapp.entity.question.QuestionMultiple;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@DiscriminatorValue("MULTIPLE")
public class BookQuestionMultiple extends BookQuestion{

	private static final long serialVersionUID = -185261467596156689L;

	@Column(name = "selected_answer_id", nullable = true, insertable = true, updatable = true)
	protected Long selectedAnswerId;

	@ManyToOne
	@JoinColumn(name = "selected_answer_id", nullable = true, insertable = false, updatable = false)
	protected IncorrectAnswer selectedAnswer;

	@Override
	protected Boolean isCorrect() {
		return ((QuestionMultiple) this.question).getCorrectAnswer().equals(this.selectedAnswer.getAnswer());
	}	
}
