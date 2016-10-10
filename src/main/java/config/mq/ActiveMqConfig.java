package config.mq;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {
	@Bean
	public ActiveMQConnectionFactory activemqConnectionFactory()
	{
		ActiveMQConnectionFactory mqCf = new ActiveMQConnectionFactory();
		mqCf.setBrokerURL("tcp://192.168.12.112:61616");
		return mqCf;
	}
	@Bean
	public PooledConnectionFactory activemqPooledConnectionFactory(ActiveMQConnectionFactory mqcf)
	{
		PooledConnectionFactory pooledCf = new PooledConnectionFactory(mqcf);
		return pooledCf;
	}
	@Bean
	public JmsTemplate jmsTemplate(PooledConnectionFactory pooledCf)
	{
		JmsTemplate jmsTemplate = new JmsTemplate(pooledCf);
		jmsTemplate.setReceiveTimeout(10000);
		return jmsTemplate;
	}
}
