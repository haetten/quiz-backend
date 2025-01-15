package br.com.fhsistemas.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fhsistemas.quizapp.entity.book.Book;
import br.com.fhsistemas.quizapp.generic.model.Parameter;
import br.com.fhsistemas.quizapp.generic.model.QueryFilter;
import br.com.fhsistemas.quizapp.generic.service.GenericEntityManagerService;

@Service
public class BookService  extends GenericEntityManagerService<Book, Long, QueryFilter>{

	public BookService() {
		super(Book.class);
	}

	@Override
	protected List<Parameter> buildParameters(QueryFilter filter) {
		return new ArrayList<>();
	}

	@Override
	protected List<Book> postProcessing(List<Book> results) {
		return results;
	}

	@Override
	protected String getJoin(QueryFilter consulta) {
		return "";
	}


	
}