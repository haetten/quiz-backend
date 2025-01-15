package br.com.fhsistemas.quizapp.entity.question;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "discipline")
public class Discipline extends PersistentEntity<Long> {

	private static final long serialVersionUID = -3066458828456851175L;
	
	@Column(nullable = false, insertable = true, updatable = true)
	protected String name;

}
