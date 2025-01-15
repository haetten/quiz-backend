package br.com.fhsistemas.quizapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fhsistemas.quizapp.entity.question.Question;
import br.com.fhsistemas.quizapp.entity.question.QuestionBoolean;
import br.com.fhsistemas.quizapp.entity.question.QuestionMultiple;
import br.com.fhsistemas.quizapp.filter.QuestionFilter;
import br.com.fhsistemas.quizapp.generic.model.Parameter;
import br.com.fhsistemas.quizapp.generic.service.GenericEntityManagerService;
import jakarta.transaction.Transactional;

@Service
public class QuestionService extends GenericEntityManagerService<Question, Long, QuestionFilter>{

	public QuestionService() {
		super(Question.class);
	}

	@Override
	public List<Parameter> buildParameters(QuestionFilter filter){
		List<Parameter> parametros = new ArrayList<>();

		parametros.add(new Parameter(" type = ? ", filter.getType()));
		parametros.add(new Parameter(" categoryId = ? ", filter.getCategory()));
		parametros.add(new Parameter(" difficulty = ? ", filter.getDifficulty()));
		parametros.add(new Parameter(" question ILIKE %?% ", filter.getQuestion()));

		List<Parameter> parametrosVazios = new ArrayList<>();
		for (Parameter parametro : parametros) {
			if (parametro.getValor() == null) parametrosVazios.add(parametro);
		}

		parametros.removeAll(parametrosVazios);
		
		return parametros;
		
	}

	@Override
	protected List<Question> postProcessing(List<Question> results){
		Collections.shuffle(results);
		
		return results;
	}

	@Override
	protected String getJoin(QuestionFilter consulta) {
		return "";
	}

	public QuestionMultiple findMultipleById(Long id) {
		return entityManager.find(QuestionMultiple.class, id);
	}


	public QuestionBoolean findBooleanById(Long id) {
		return entityManager.find(QuestionBoolean.class, id);
	}


	@Transactional
	public QuestionMultiple save(QuestionMultiple obj) {
		obj.setCreationDate(new Date());

		obj = entityManager.merge(obj);
		entityManager.flush();
		
		return obj;
	}

	@Transactional
	public QuestionBoolean save(QuestionBoolean obj) {
		obj.setCreationDate(new Date());

		obj = entityManager.merge(obj);
		entityManager.flush();
		
		return obj;
	}
	
	
	

}
