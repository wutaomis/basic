package config.db;

import com.fasterxml.jackson.annotation.JsonAutoDetect;  
import com.fasterxml.jackson.annotation.PropertyAccessor;  
import com.fasterxml.jackson.databind.ObjectMapper; 

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.RedisUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
public class RedisConfig {
	@Bean
	public ResourceBundle jedisRb()
	{
		return ResourceBundle.getBundle("redis"); 
	}

	@Bean
	public GenericObjectPoolConfig jedisPoolCfg(ResourceBundle rb) {
		GenericObjectPoolConfig poolCfg = new GenericObjectPoolConfig();
		// …Ë÷√maxTotal
		poolCfg.setMaxTotal(Integer.valueOf(rb.getString("maxTotal").trim()));
		// …Ë÷√maxIdle
		poolCfg.setMaxTotal(Integer.valueOf(rb.getString("maxIdle").trim()));
		return poolCfg;
	}
	// use jedis cluster to connect clusters directly
	@Bean
	public JedisCluster jedisCluster(ResourceBundle rb, GenericObjectPoolConfig poolCfg)
	{
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		//Jedis Cluster will attempt to discover cluster nodes automatically
		String address = rb.getString("clusterAddress").trim();
		String[] addressSplit = address.split(":");
		jedisClusterNodes.add(new HostAndPort(addressSplit[0].trim(),Integer.valueOf(addressSplit[1].trim())));
		return new JedisCluster(jedisClusterNodes,poolCfg);
	}
	// use connection factory to connect single node or clusters
//	@Bean
//	public RedisConnectionFactory redisCF()
//	{
//		// connect single node
//		JedisConnectionFactory cf = new JedisConnectionFactory();
//		cf.setHostName("192.168.12.112");
//		cf.setPort(9000);
//		return cf;
//	}
	@Bean 
	public RedisClusterConfiguration clusterConfig()
	{
		Collection<String> clusterNodes = new ArrayList<String>();
		clusterNodes.add("192.168.12.112:9000");
		Map<String, Object> source = new HashMap<String, Object>();
        source.put("spring.redis.cluster.nodes", "192.168.12.112:9000");
        source.put("spring.redis.cluster.timeout", 1000);
        source.put("spring.redis.cluster.max-redirects", 8);
		return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
	}
	@Bean
	public RedisConnectionFactory redisCC(RedisClusterConfiguration rcc)
	{
		// connect single node
		JedisConnectionFactory cf = new JedisConnectionFactory(rcc);
		return cf;
	}
	@Bean
	public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory cf)
	{
		RedisTemplate<String,Object> redis = new RedisTemplate<String,Object>();
		redis.setConnectionFactory(cf);
		redis.setKeySerializer(new StringRedisSerializer());
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);  
        ObjectMapper om = new ObjectMapper();  
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
        jackson2JsonRedisSerializer.setObjectMapper(om);  
        redis.setValueSerializer(jackson2JsonRedisSerializer);  
        redis.afterPropertiesSet();  
		return redis;
	}
	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory cf)
	{
		return new StringRedisTemplate(cf);
	}
}
