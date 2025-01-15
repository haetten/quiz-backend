package br.com.fhsistemas.quizapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhsistemas.quizapp.entity.question.Category;
import br.com.fhsistemas.quizapp.generic.controller.GenericRepositoryController;
import br.com.fhsistemas.quizapp.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "categories", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController
extends GenericRepositoryController<Category, Long, CategoryService> {
	
	protected CategoryController(CategoryService service) {
		super(service);
	}
	
}
