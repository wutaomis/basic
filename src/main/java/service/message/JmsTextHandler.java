package service.message;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JmsTextHandler {
	private static Logger log = LogManager.getLogger(JmsTextHandler.class);
	public void handleText(TextMessage text)
	{
		try {
			log.info(text.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
