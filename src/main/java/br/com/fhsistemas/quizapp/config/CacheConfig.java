package br.com.fhsistemas.quizapp.config;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    private final CacheManager cacheManager;

    public CacheConfig(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Bean
    DynamicCacheResolver dynamicCacheResolver() {
        return new DynamicCacheResolver(cacheManager);
    }
}
