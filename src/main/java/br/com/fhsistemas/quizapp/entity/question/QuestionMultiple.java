package br.com.fhsistemas.quizapp.entity.question;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@DiscriminatorValue("MULTIPLE")
public class QuestionMultiple extends Question {
	
	private static final long serialVersionUID = 5361735926092628560L;


	public QuestionMultiple() {
		super();
		this.incorrectAnswers = new ArrayList<>();
	}
	
	@Column(name = "correct_answer_multiple")
	protected String correctAnswer;

//    @ElementCollection
//    @CollectionTable(name = "incorrect_answer", joinColumns = @JoinColumn(name = "question_id"))
//    @Column(name = "answer")
//	protected List<String> incorrectAnswers = new ArrayList<>();
    
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	protected List<IncorrectAnswer> incorrectAnswers;
	
	@Override
	public String getCorrectAnswerString() {
		return getCorrectAnswer();
	}

	@Override
	public List<String> getIncorrectAnswersString() {
		return getIncorrectAnswers().stream().map(IncorrectAnswer::getAnswer).toList();
//		return getIncorrectAnswers();
	}

	public void addIncorrectAnswer(String answer) {
		getIncorrectAnswers().add(new IncorrectAnswer(this, answer));
//		getIncorrectAnswers().add( answer);
	}

}
