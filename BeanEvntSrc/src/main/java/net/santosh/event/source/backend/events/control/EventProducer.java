package net.santosh.event.source.backend.events.control;

import java.util.Objects;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.CoffeeEvent;

@Component
@Profile("NONE")
public class EventProducer {

	@Autowired(required = false)
	@Qualifier("activeMQJMS")
	JmsTemplate					   jmsTemplate;
	
	public void send(Destination queueName, CoffeeEvent messageToDrop) {

		if (Objects.nonNull(jmsTemplate)) {
			jmsTemplate.convertAndSend(queueName, messageToDrop);
		}
	}

}

