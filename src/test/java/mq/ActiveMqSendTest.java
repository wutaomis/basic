package mq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.pool.PooledConnectionFactory;
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
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.mq.ActiveMqConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ActiveMqConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
@ActiveProfiles("home")
public class ActiveMqSendTest {
	private static Logger log = LogManager.getLogger(ActiveMqSendTest.class);
	@Autowired
	private JmsOperations jmsOperations;
	
	
//	@Before
//	public void setupTest()
//	{
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"}); 
//		jmsOperations = (JmsOperations) ctx.getBean("jmsTemplate");
//		PooledConnectionFactory pooledCf = (PooledConnectionFactory) ctx.getBean("activemqPooledConnectionFactory");		
//	}
	@Ignore
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
	@Ignore
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
