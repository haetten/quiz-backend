package br.com.fhsistemas.quizapp.generic.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import br.com.fhsistemas.quizapp.generic.model.Parameter;
import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import br.com.fhsistemas.quizapp.generic.model.QueryFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public abstract class GenericEntityManagerService<
	T extends PersistentEntity<I>
  , I extends Serializable
  , Q extends QueryFilter
>
extends GenericService<T, I>{

	@PersistenceContext
	public EntityManager entityManager;

	protected GenericEntityManagerService(Class<T> className) {
		super(className);
	}

	protected abstract List<Parameter> buildParameters(Q filter) ;

	protected abstract List<T> postProcessing(List<T> results) ;

	protected abstract String getJoin(Q consulta) ;

    
    private String getStringHqlParameters(List<Parameter> parameters) {
		StringBuilder hql = new StringBuilder();
    	
		for(Parameter parametro : parameters) {
			if(parametro.getValor() != null)
				hql.append(" AND " + parametro.getQuery());
		}
		
		return hql.toString();
	
    }
    
    private Query setQueryParameters(Query q, List<Parameter> parameters) {
		for(Parameter parametro : parameters) {
			if(parametro.getValor() != null)
				q.setParameter(parametro.getNome(), parametro.getValor());
		}
		
		return q;
    	
    }

	public Long count(Q filter) {
		StringBuilder hql = new StringBuilder(" SELECT count(DISTINCT p) ");
		
		List<Parameter> parametros = buildParameters(filter);
		hql.append(" FROM " + getClassName().getSimpleName() + " " + getJoin(filter) + " p WHERE 1=1 ");
		hql.append(getStringHqlParameters(parametros));
				
		Query q = entityManager.createQuery(hql.toString());
		setQueryParameters(q, parametros);
		
		return (Long) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(Q filter) {
		StringBuilder hql = new StringBuilder(" SELECT p ");
		
		List<Parameter> parametros = buildParameters(filter);
		hql.append(" FROM " + getClassName().getSimpleName() + " " + getJoin(filter) + " p WHERE 1=1 ");
		hql.append(getStringHqlParameters(parametros));

		hql.append(StringUtils.isNotEmpty(filter.getOrderBy()) ? " ORDER BY " + filter.getOrderBy() : "");
		
		Query q = entityManager.createQuery(hql.toString(), getClassName());
		setQueryParameters(q, parametros);
		
		
		if (filter.getPageSize() != null) {
			q.setFirstResult((filter.getPageNumber() - 1) * filter.getPageSize());
			q.setMaxResults(filter.getPageSize());
		}
		
		return postProcessing(new ArrayList<>(new HashSet<>(q.getResultList())));
	}

	
	@Override
	public List<T> find() {
		return entityManager.createQuery(
				" SELECT DISTINCT p FROM "
				+ getClassName().getSimpleName() + " p"
//				+ getFindOrderBy(null)
			, getClassName())
			.getResultList();
	}

	@Override
	public Long count() {
		return (Long) entityManager.createQuery(
				" SELECT COUNT(DISTINCT p) FROM "
				+ getClassName().getSimpleName() + " p"
//				+ getFindOrderBy(null)
				)
				.getSingleResult();
	}

	@Override
    @Cacheable(cacheResolver = "dynamicCacheResolver", key = "#id")
	public T findById(I id) {
		return entityManager.find(getClassName(), id);
	}

	@Override
	@Transactional
	public T save(T obj) {
		obj.setCreationDate(new Date());

		entityManager.persist(obj);
		entityManager.flush();
		
		return obj;
	}

	@Override
	@Transactional
	@CacheEvict(cacheResolver = "dynamicCacheResolver", key = "#obj.id")
	public T update(T obj) {
		obj.setLastChangeDate(new Date());

		obj = entityManager.merge(obj);
		entityManager.flush();
		
		return obj;
	}

	@Override
	@Transactional
	@CacheEvict(cacheResolver = "dynamicCacheResolver", key = "#id")
	public void delete(I id) {
		T obj = entityManager.getReference(getClassName(), id);
		obj.setRemoveDate(new Date());

		entityManager.merge(obj);
		entityManager.flush();
	}


}