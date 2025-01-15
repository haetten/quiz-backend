package br.com.fhsistemas.quizapp.service;

import org.springframework.stereotype.Service;

import br.com.fhsistemas.quizapp.entity.question.Category;
import br.com.fhsistemas.quizapp.generic.service.GenericRepositoryService;
import br.com.fhsistemas.quizapp.repository.CategoryRepository;

@Service
public class CategoryService extends GenericRepositoryService<Category, Long, CategoryRepository> {

	public CategoryService(CategoryRepository repository) {
		super(Category.class, repository);
	}

}
