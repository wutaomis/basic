package sql;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cache.CacheTest;
import mybatis.IDao.Tstrfv2Mapper;
import mybatis.domain.Tstrfv2;
import mysql.dao.Tstrfv2Dao;
import product.CacheProduct;
import service.QueryProduct;

public class MysqlTest {
	private static Logger log = LogManager.getLogger(MysqlTest.class);
	private Tstrfv2Dao dao;
	private Tstrfv2Mapper tstrfv2Mapper;
	@Before
	public void setupTest()
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}); 
		dao = (Tstrfv2Dao) ctx.getBean("tstrfv2Dao");
		tstrfv2Mapper = (Tstrfv2Mapper)ctx.getBean(Tstrfv2Mapper.class);
	}
	@Test
	public void testJdbc() {
		List<Map<String,Object>> lm = dao.findALL("select * from ebb_tstrfv2");
		for (Map<String,Object> item : lm)
		{
			for (String key : item.keySet())
			{
				log.info(key + ":" + item.get(key));
			}
		}
	}
	@Test
	public void testMybatis() {
		Tstrfv2 obj = tstrfv2Mapper.selectByPrimaryKey("0000");
		log.info(obj.getTranscode() + ":" + obj.getTransname());
	}
}
