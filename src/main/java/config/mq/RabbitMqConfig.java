package config.mq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

//@Configuration
public class RabbitMqConfig {
	@Bean
	@Profile("home")
	public CachingConnectionFactory rabbitmqConnectionFactoryHome()
	{
		CachingConnectionFactory rabbitmqCf = new CachingConnectionFactory();
		rabbitmqCf.setHost("192.168.12.112");
		rabbitmqCf.setPort(5672);
		return rabbitmqCf;
	}
	@Bean
	@Profile("office")
	public CachingConnectionFactory rabbitmqConnectionFactoryOffice()
	{
		CachingConnectionFactory rabbitmqCf = new CachingConnectionFactory();
		rabbitmqCf.setHost("192.168.99.100");
		rabbitmqCf.setPort(32769);
		return rabbitmqCf;
	}
	@Bean
	public RabbitTemplate rabbitTemplate(CachingConnectionFactory rabbitmqCf)
	{
		RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitmqCf);
		return rabbitTemplate;
	}
}
