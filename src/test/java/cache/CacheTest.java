package cache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.JavaBasic;
import product.CacheProduct;
import service.QueryProduct;

public class CacheTest {
	private static Logger log = LogManager.getLogger(CacheTest.class);
	private QueryProduct qp;
	@Before
	public void setupTest()
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}); 
		qp = (QueryProduct) ctx.getBean("queryProduct");
	}
	@Ignore
	@Test
	public void testCache() {
		log.info("call first time");
		CacheProduct cpt = qp.getProduct("wutao");
		log.info("call second time");
		CacheProduct cpt2 = qp.getProduct("wutao");
		log.info(cpt2.getName());
	}
}
