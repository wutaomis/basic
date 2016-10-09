package config.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class ReidsCacheConfig {
	@Bean
	public CacheManager redisCacheManager(RedisTemplate redisTemplate)
	{
		return new RedisCacheManager(redisTemplate);
	}
}
