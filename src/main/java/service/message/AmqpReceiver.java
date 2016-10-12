package service.message;

import javax.jms.TextMessage;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpReceiver implements MessageListener {
//public class AmqpReceiver {
	@Override
	public void onMessage(Message msg) {
		try {
			System.out.print(msg.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void handleMessge(Message msg) {
//		try {
//			System.out.print(msg.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}