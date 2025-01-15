package br.com.fhsistemas.quizapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhsistemas.quizapp.entity.question.Discipline;
import br.com.fhsistemas.quizapp.generic.controller.GenericRepositoryController;
import br.com.fhsistemas.quizapp.service.DisciplineService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "disciplines", produces = MediaType.APPLICATION_JSON_VALUE)
public class DisciplineController
extends GenericRepositoryController<Discipline, Long, DisciplineService> {
	
	protected DisciplineController(DisciplineService service) {
		super(service);
	}
	
}
