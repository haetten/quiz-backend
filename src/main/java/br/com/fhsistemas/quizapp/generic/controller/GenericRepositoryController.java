package br.com.fhsistemas.quizapp.generic.controller;

import java.io.Serializable;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import br.com.fhsistemas.quizapp.generic.service.GenericRepositoryService;

public abstract class GenericRepositoryController<
	T extends PersistentEntity<I>
  , I extends Serializable
  , S extends GenericRepositoryService<T, I, ?>
> 
extends GenericController<T, I, S> {

	protected GenericRepositoryController(S service) {
		super(service);
	}
    
}
