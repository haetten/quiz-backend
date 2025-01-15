package br.com.fhsistemas.quizapp.generic.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;

public abstract class GenericRepositoryService<
	T extends PersistentEntity<I>
  , I extends Serializable
  , R extends JpaRepository<T, I>
> 
extends GenericService<T, I> {

    protected R repository;

    protected GenericRepositoryService(Class<T> className, R repository) {
    	super(className);
        this.repository = repository;
    }

    @Override
    public List<T> find() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    @Cacheable(cacheResolver = "dynamicCacheResolver", key = "#id")
    public T findById(I id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade com I " + id + " não encontrada."));
    }

    @Override
    @CacheEvict(cacheResolver = "dynamicCacheResolver", key = "#obj.id")
    public T save(T obj) {
        return repository.save(obj);
    }

    @Override
    @CacheEvict(cacheResolver = "dynamicCacheResolver", key = "#obj.id")
    public T update(T obj) {
        return repository.save(obj);
    }

    @Override
    @CacheEvict(cacheResolver = "dynamicCacheResolver", key = "#id")
    public void delete(I id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entidade com I " + id + " não encontrada.");
        }
        repository.deleteById(id);
    }
}