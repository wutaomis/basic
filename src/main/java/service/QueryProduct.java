package service;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import main.JavaBasic;
import product.CacheProduct;

@Service
public class QueryProduct {
	private static Logger log = LogManager.getLogger(JavaBasic.class);
	@Cacheable(value="productCache")
	public CacheProduct getProduct(String name)
	{
		CacheProduct pt= new CacheProduct();
		pt.setName(name);
		log.info("call in QueryProduct " + pt.getName());
		return pt;
	}
}
