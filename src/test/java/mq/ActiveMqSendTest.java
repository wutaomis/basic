package mq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;

import mybatis.IDao.Tstrfv2Mapper;
import mysql.dao.Tstrfv2Dao;
import product.CacheProduct;
import sql.MysqlTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class ActiveMqSendTest {
	private static Logger log = LogManager.getLogger(ActiveMqSendTest.class);
	private JmsOperations jmsOperations;
	
	@Before
	public void setupTest()
	{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}); 
		jmsOperations = (JmsOperations) ctx.getBean("jmsTemplate");
		PooledConnectionFactory pooledCf = (PooledConnectionFactory) ctx.getBean("activemqPooledConnectionFactory");		
	}
	@Test
	public void testActiveMq1Send() {
		log.info("in testActiveMqSend");
		jmsOperations.send("foo.bar", new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return session.createTextMessage(format.format(date));
			}
		});
	}
	@Test
	public void testActiveMq2Recv() {
		log.info("in testActiveMqRecv");
		while (true)
		{
			TextMessage msg = (TextMessage)jmsOperations.receive("foo.bar");
			if (null != msg)
			{
				try {
					log.info(msg.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				break;
			}
		}
	}
}
