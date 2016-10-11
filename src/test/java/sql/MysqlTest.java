package sql;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.sql.MysqlConfig;
import mybatis.IDao.Tstrfv2Mapper;
import mybatis.domain.Tstrfv2;
import mysql.dao.Tstrfv2Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@ActiveProfiles("office")
public class MysqlTest {
	private static Logger log = LogManager.getLogger(MysqlTest.class);
	@Autowired
	private Tstrfv2Dao dao;
	@Autowired
	private Tstrfv2Mapper tstrfv2Mapper;
//	@Before
//	public void setupTest()
//	{
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}); 
//		dao = (Tstrfv2Dao) ctx.getBean("tstrfv2Dao");
//		tstrfv2Mapper = (Tstrfv2Mapper)ctx.getBean(Tstrfv2Mapper.class);
//	}
	@Ignore
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
	@Ignore
	@Test
	public void testMybatis() {
		Tstrfv2 obj = tstrfv2Mapper.selectByPrimaryKey("0000");
		log.info(obj.getTranscode() + ":" + obj.getTransname());
	}
}
