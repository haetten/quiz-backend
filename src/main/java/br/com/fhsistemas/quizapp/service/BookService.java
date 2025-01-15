package br.com.fhsistemas.quizapp.service;

import org.springframework.stereotype.Service;

import br.com.fhsistemas.quizapp.entity.book.Book;
import br.com.fhsistemas.quizapp.generic.model.GenericFilter;
import br.com.fhsistemas.quizapp.generic.service.GenericEntityManagerService;

@Service
public class BookService  extends GenericEntityManagerService<Book, Long, GenericFilter>{

	public BookService() {
		super(Book.class);
	}

}