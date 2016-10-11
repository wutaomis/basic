package config.mq;

import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class RabbitMqConfig {
	@Bean
	public CachingConnectionFactory rabbitmqConnectionFactory()
	{
		CachingConnectionFactory rabbitmqCf = new CachingConnectionFactory();
		rabbitmqCf.setHost("192.168.12.110");
		return rabbitmqCf;
	}
	@Bean
	public JmsTemplate jmsTemplate(CachingConnectionFactory rabbitmqCf)
	{
		JmsTemplate jmsTemplate = new JmsTemplate(pooledCf);
		jmsTemplate.setReceiveTimeout(10000);
		return jmsTemplate;
	}
}
