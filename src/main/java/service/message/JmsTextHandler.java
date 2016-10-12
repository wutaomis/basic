package service.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JmsTextHandler implements MessageListener{
	private static Logger log = LogManager.getLogger(JmsTextHandler.class);
	@Override
	public void onMessage(Message text) {
		System.out.println(text.toString());
	}
}
