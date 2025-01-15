package br.com.fhsistemas.quizapp.entity.book;

import java.util.List;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "book")
public class Book extends PersistentEntity<Long> {

	private static final long serialVersionUID = 6121439173022056393L;
	
	@Column(nullable = false, insertable = true, updatable = true)
	protected String name;
	
	@OneToMany(mappedBy = "book")
	protected List<BookQuestion> questions;
}
