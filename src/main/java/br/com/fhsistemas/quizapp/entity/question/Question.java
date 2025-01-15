package br.com.fhsistemas.quizapp.entity.question;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "question")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Question extends PersistentEntity<Long> {

	private static final long serialVersionUID = -3964412609945875762L;

	public enum QuestionType{
		BOOLEAN, MULTIPLE
	}

	public enum QuestionDifficulty{
		EASY, MEDIUM, HARD
	}
	
	@Column(nullable = false, insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	protected QuestionType type;
	
	@Column(nullable = false, insertable = true, updatable = true)
	@Enumerated(EnumType.STRING)
	protected QuestionDifficulty difficulty;

	@Column(name = "category_id", nullable = false, insertable = true, updatable = true)
	protected Long categoryId;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	@JsonIgnore
	protected Category category;

	@Column(nullable = false, insertable = true, updatable = true)
	protected String question;

	@Column(nullable = true, insertable = true, updatable = true)
    protected String explanation;

	@Transient
	public String getCorrectAnswerString() {return "";}

	@Transient
	public List<String> getIncorrectAnswersString() {return new ArrayList<>();}

}
