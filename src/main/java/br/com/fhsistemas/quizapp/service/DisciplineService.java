package br.com.fhsistemas.quizapp.service;

import org.springframework.stereotype.Service;

import br.com.fhsistemas.quizapp.entity.question.Discipline;
import br.com.fhsistemas.quizapp.generic.service.GenericRepositoryService;
import br.com.fhsistemas.quizapp.repository.DisciplineRepository;

@Service
public class DisciplineService extends GenericRepositoryService<Discipline, Long, DisciplineRepository> {

	public DisciplineService(DisciplineRepository repository) {
		super(Discipline.class, repository);
	}

}
