package br.com.fhsistemas.quizapp.entity.question;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "category")
public class Category extends PersistentEntity<Long> {

	private static final long serialVersionUID = -8081329347993379498L;

	@Column(name = "discipline_id", nullable = true, insertable = true, updatable = true)
	protected Long disciplineId;

	@ManyToOne
	@JoinColumn(name = "discipline_id", insertable = false, updatable = false)
	protected Discipline discipline;

	@Column(nullable = false, insertable = true, updatable = true)
	protected String name;

	@Column(name = "parent_category_id", nullable = true, insertable = true, updatable = true)
	protected Long parentCategoryId;

	@ManyToOne
	@JoinColumn(name = "parent_category_id", insertable = false, updatable = false)
	@JsonIgnore
	protected Category parentCategory;
	
	@Transient
	public String getFullName() {
		return parentCategory != null ? parentCategory.getFullName() + " > " + name : name;
	}

}
