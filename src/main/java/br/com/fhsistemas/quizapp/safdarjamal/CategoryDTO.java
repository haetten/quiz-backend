package br.com.fhsistemas.quizapp.safdarjamal;

import br.com.fhsistemas.quizapp.entity.question.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	protected Long key;
	protected String text;
	protected Long value;
	
	public CategoryDTO(Category category) {
		this.value = category.getId();
		this.key = category.getId();
		this.text = category.getName();
	}

}
