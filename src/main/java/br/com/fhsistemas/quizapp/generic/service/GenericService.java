package br.com.fhsistemas.quizapp.generic.service;

import java.io.Serializable;
import java.util.List;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import lombok.Getter;

public abstract class GenericService<T extends PersistentEntity<I>, I extends Serializable> {

    public abstract List<T> find() ;

    public abstract Long count() ;

    public abstract T save(T obj) ;

    public abstract T update(T obj) ;

    public abstract T findById(I id) ;

    public abstract void delete(I id) ;


    @Getter private final Class<T> className;
    
    protected GenericService(Class<T> className) {
        this.className = className;
    }
    
	public String getCacheName() {
		return className.getSimpleName();
	}
}
