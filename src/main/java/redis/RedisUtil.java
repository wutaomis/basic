package redis;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisUtil {
	private static Logger log = LogManager.getLogger(RedisUtil.class);
	private static JedisCluster instance = null;
	private final static String defaultClusterAddress="127.0.0.1:6379";
	
	ResourceBundle rb = null;
	private RedisUtil()
	{
		rb = ResourceBundle.getBundle("redis"); 
	}
	
	private GenericObjectPoolConfig initJedisPoolCfg()
	{
		GenericObjectPoolConfig poolCfg = new GenericObjectPoolConfig();
	    // 通过资源包拿到所有的key  
		if (rb != null)
		{
			// 设置maxTotal
			poolCfg.setMaxTotal(Integer.valueOf(rb.getString("maxTotal").trim()));
			// 设置maxIdle
			poolCfg.setMaxTotal(Integer.valueOf(rb.getString("maxIdle").trim()));
		}
		else
		{
			log.error("can't read resource bundle, use default configuration");
		}
		return poolCfg;
	}
	private Set<HostAndPort> initClusterAddress()
	{
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		//Jedis Cluster will attempt to discover cluster nodes automatically
		String address = defaultClusterAddress;
		if (rb != null) {
			address = rb.getString("clusterAddress").trim();
		}
		else
		{
			log.error("can't read resource bundle, use cluster address");
		}
		String[] addressSplit = address.split(":");
		jedisClusterNodes.add(new HostAndPort(addressSplit[0].trim(),Integer.valueOf(addressSplit[1].trim())));
		return jedisClusterNodes;
	}
	//双重同步锁确保线程安全
	public static JedisCluster JCFactory()
	{
		if (instance == null)
		{
			synchronized(RedisUtil.class)
			{
				if (instance == null)
				{
					RedisUtil ru = new RedisUtil();
					Set<HostAndPort> nodes = ru.initClusterAddress();
					GenericObjectPoolConfig poolCfg = ru.initJedisPoolCfg();
					instance = new JedisCluster(nodes,poolCfg);
				}
			}
		}
		return instance;
	}
}
