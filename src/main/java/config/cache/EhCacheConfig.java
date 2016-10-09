package config.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;


@Configuration
@EnableCaching
public class EhCacheConfig {
//	@Bean
//	public CacheManager cacheManager()
//	{
//		return new ConcurrentMapCacheManager();
//	}
//	@Bean
//	public EhCacheCacheManager ehCacheManager(CacheManager cm)
//	{
//		return new EhCacheCacheManager(cm); 
//	}
//	@Bean
//	public EhCacheManagerFactoryBean ehCache()
//	{
//		EhCacheManagerFactoryBean ehCacheFactoryBean = 
//				new EhCacheManagerFactoryBean();
//		ehCacheFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//		return ehCacheFactoryBean;
//	}
}
