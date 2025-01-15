package br.com.fhsistemas.quizapp.entity.book;

import java.io.Serializable;
import java.util.Objects;

import br.com.fhsistemas.quizapp.entity.book.BookQuestion.BookQuestionId;
import br.com.fhsistemas.quizapp.entity.question.Question;
import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
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
@Table(name = "book_question")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class BookQuestion extends PersistentEntity<BookQuestionId> {
	
	private static final long serialVersionUID = -5586139055410787879L;

	@Embeddable
    @Data
    public static class BookQuestionId implements Serializable {
        private static final long serialVersionUID = -2178217803830034267L;

		@Column(name = "question_id")
        private Long questionId;

        @Column(name = "book_id")
        private Long bookId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BookQuestionId that = (BookQuestionId) o;
            return Objects.equals(questionId, that.questionId) && Objects.equals(bookId, that.bookId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(questionId, bookId);
        }
    }

    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
	protected Question question;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
	protected Book book;

	@Transient
	protected abstract Boolean isCorrect() ;
}
