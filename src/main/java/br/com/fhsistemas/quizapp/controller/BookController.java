package br.com.fhsistemas.quizapp.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhsistemas.quizapp.dto.ResponderQuestaoDTO;
import br.com.fhsistemas.quizapp.entity.book.Book;
import br.com.fhsistemas.quizapp.generic.controller.GenericEntityManagerController;
import br.com.fhsistemas.quizapp.service.BookService;
import br.com.fhsistemas.quizapp.service.QuestionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController 
extends GenericEntityManagerController<Book, Long, BookService> {
	
	protected final QuestionService questoesService;
		
	protected BookController(BookService service, QuestionService questoesService) {
		super(service);
		this.questoesService = questoesService;
	}
	

    @PatchMapping(value = "/responder")
    public ResponseEntity<?> responderQuestao(ResponderQuestaoDTO dto) {
    	return null;
    }

}
