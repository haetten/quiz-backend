package br.com.fhsistemas.quizapp.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import br.com.fhsistemas.quizapp.generic.service.GenericService;

public class DynamicCacheResolver implements CacheResolver {

    private final CacheManager cacheManager;

    public DynamicCacheResolver(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        // Usa o nome da classe como nome do cache
//        String cacheName = context.getTarget().getClass().getSimpleName();
        @SuppressWarnings("rawtypes")
		String cacheName = context.getTarget() instanceof GenericService
                ? ((GenericService) context.getTarget()).getCacheName()
                : context.getTarget().getClass().getSimpleName(); // Fallback para o nome da classe
        
        
        Cache cache = cacheManager.getCache(cacheName);
        return cache != null ? Collections.singletonList(cache) : Collections.emptyList();
    }
}
