package config.mq;

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
		mqCf.setBrokerURL("tcp://localhost:61616");
		return mqCf;
	}
	@Bean
	public JmsTemplate jmsTemplate(ActiveMQConnectionFactory mqCf)
	{
		return new JmsTemplate(mqCf);
	}
}
