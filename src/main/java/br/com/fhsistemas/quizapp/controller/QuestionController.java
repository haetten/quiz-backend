package br.com.fhsistemas.quizapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhsistemas.quizapp.dto.QuestionSaveRequest;
import br.com.fhsistemas.quizapp.entity.question.Question;
import br.com.fhsistemas.quizapp.entity.question.QuestionFactory;
import br.com.fhsistemas.quizapp.generic.controller.GenericEntityManagerController;
import br.com.fhsistemas.quizapp.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "questions", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController
extends GenericEntityManagerController<Question, Long, QuestionService> {
	
	private final QuestionFactory factory;
	
	protected QuestionController(QuestionService service) {
		super(service);
		this.factory = new QuestionFactory(service);
	}
	
    @Override
    @Operation(hidden = true)
    @PostMapping
    public ResponseEntity<Question> save(@RequestBody Question question) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
	
    @Override
    @Operation(hidden = true)
    @PutMapping
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody QuestionSaveRequest obj) {
        return ResponseEntity.ok(service.save(factory.createQuestion(obj)));
    }
    
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody QuestionSaveRequest obj) {
        return ResponseEntity.ok(service.update(factory.createQuestion(obj)));
    }
}
