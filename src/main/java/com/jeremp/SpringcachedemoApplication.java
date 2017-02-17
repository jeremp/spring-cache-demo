package com.jeremp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@EnableCaching
public class SpringcachedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcachedemoApplication.class, args);
	}
	
	@Bean
	public CacheManager cacheManager() {
		final EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehCacheCacheManager().getObject());
		return ehCacheCacheManager;
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
}
