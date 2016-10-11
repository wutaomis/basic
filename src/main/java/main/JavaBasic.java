package main;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import misc.*;
import product.CacheProduct;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import service.QueryProduct;

public class JavaBasic implements Serializable {

	private static Logger log = LogManager.getLogger(JavaBasic.class);

	String name;
	int age;

	public JavaBasic modifyObj(JavaBasic obj) {
		System.out.println(obj);
		obj.name = "liqian";
		return obj;
	}

	public boolean equals(JavaBasic obj) {
		return this.name.equals(obj.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}); 
		// how to use Converter
		/*
		 * System.out.println(new Converter().fromString("394"));
		 */

		// difference between == and equal
		/*
		 * { log.info("difference between == and equals"); BasicJava p1 = new
		 * BasicJava(); p1.name = "wutao"; BasicJava p2 = new BasicJava();
		 * p2.name = "wutao"; BasicJava p3 = p1; if (p1 == p3) { log.info(
		 * "p1 == p3"); }
		 * 
		 * if (p1 == p2) { log.info("p1 == p2"); }
		 * 
		 * if (p1.equals(p2)) { log.info("p1.equals(p2)"); }
		 * 
		 * // how to determine instance's type log.info(p1.getClass());
		 * log.info(p1 instanceof BasicJava); Object nAge = 5;
		 * log.info(nAge.getClass());
		 * log.info("=============================="); }
		 */
		// how to use lamda expression

		// how to use set, hashmap

		// how to develop multi-thread program

		// how to use DI and aop

		// how to use mybatis to access database

		// how to access redis with ordinary method
		{
			// log.info("how to access redis");
			// {
			// //jedis direct access,多个线程共享一个jedis实例会可能出现问题
			// //为每个线程创建jedis实例开销太大，如果创建太多的实例也可能出现问题
			// //jedis cluster默认使用线程池连接redis
			//
			// JedisCluster jc = RedisUtil.JCFactory();
			// try
			// {
			//// jc.set("father","wutao");
			//// jc.set("mother", "liqian");
			//// jc.set("son", "wuyuhan");
			//// log.info(jc.get("son"));
			//// log.info(jc.get("father"));
			//// log.info(jc.get("mother"));
			//
			// JavaBasic bj = new JavaBasic();
			// bj.name="wutao";
			// bj.age=31;
			// byte[] bkey = SerializeUtil.serialize("obj");
			// if (!jc.exists(bkey))
			// {
			// byte[] bval = SerializeUtil.serialize(bj);
			// jc.set(bkey, bval);
			// }
			//
			// JavaBasic bj2 = (JavaBasic)
			// SerializeUtil.unserialize(jc.get(SerializeUtil.serialize("obj")));
			// log.info("after unserialize " + bj2.name);
			// }
			// catch(Exception e)
			// {
			// log.error(e.toString());
			// }
		}
		// how to access redis directly
//		{
//			JedisCluster jc = (JedisCluster)context.getBean("jedisCluster");
//			Random rd = new Random();
//			int count = 0 ;
//			while (count < 10000)
//			{
//				String key = new Integer(rd.nextInt(100000)).toString();
////				if (!jc.exists(key))
////				{
////					String str = String.format("set key = %s, value = %s", key,key);
////					log.info(str);
////					jc.set(key, key);
////				}
//				if (jc.exists(key))
//				{
//					String value = jc.get(key);
//					String str = String.format("get key = %s, value = %s", value,value);
//					log.info(str);
//					
//				}
//				count ++;
//			}
//			try {
//				jc.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		// how to access redis with RedisTempalte
//		{
//			//StringRedisTemplate srt = (StringRedisTemplate)context.getBean("stringRedisTemplate");
//			RedisTemplate<String,Object> srt = (RedisTemplate<String,Object>)context.getBean("redisTemplate");
//			srt.setValueSerializer(new StringRedisSerializer());
//			srt.opsForValue().set("8714", "8714");
//			String value = (String)srt.opsForValue().get("8714");
//			String str = String.format("get key = %s, value = %s", value,value);
//			log.info(str);
//		}
		
		// how to use spring cache
		{

		}
	}
}
