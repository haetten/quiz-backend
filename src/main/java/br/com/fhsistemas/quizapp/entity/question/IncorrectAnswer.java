package br.com.fhsistemas.quizapp.entity.question;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "incorrect_answer")
public class IncorrectAnswer extends PersistentEntity<Long> {

	private static final long serialVersionUID = -7611708134278123030L;

	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	@ToString.Exclude
	@JsonIgnore
	protected QuestionMultiple question;

	@Column(nullable = false, insertable = true, updatable = true)
	protected String answer;
	
}
