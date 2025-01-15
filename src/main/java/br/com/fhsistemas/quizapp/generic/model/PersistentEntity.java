package br.com.fhsistemas.quizapp.generic.model;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

@MappedSuperclass
@Data
@AllArgsConstructor
@SQLRestriction("remove_date IS NULL")
public abstract class PersistentEntity<I extends Serializable> implements Serializable{
	
	private static final long serialVersionUID = 4711448909001303274L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected I id;

	@Column(name = "creation_date", nullable = false, insertable = true, updatable = true)
	protected Date creationDate;

	@Column(name = "last_change_date", nullable = true, insertable = true, updatable = true)
	protected Date lastChangeDate;

	@Column(name = "remove_date", nullable = true, insertable = true, updatable = true)
	protected Date removeDate;
	
	protected PersistentEntity() {
		this.creationDate = new Date();
	}
}
