package br.com.fhsistemas.quizapp.generic.controller;

import java.io.Serializable;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import br.com.fhsistemas.quizapp.generic.service.GenericEntityManagerService;

public abstract class GenericEntityManagerController<
	  T extends PersistentEntity<I>
	, I extends Serializable
	, S extends GenericEntityManagerService<T, I, ?>
> 
extends GenericController<T, I, S> {

	protected GenericEntityManagerController(S service) {
		super(service);
	}

}
