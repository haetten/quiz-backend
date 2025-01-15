package br.com.fhsistemas.quizapp.generic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class GenericFilter {

	protected Integer pageNumber;
	protected Integer pageSize;

	protected String orderBy;
	
	protected GenericFilter(Integer pageNumber, Integer pageSize, String orderBy) {
		this.pageNumber = pageNumber == null ? 1 : pageNumber;
		this.pageSize = pageSize;
		this.orderBy = orderBy;
	}

	
	
}
