package net.santosh.event.source.backend.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

/**
 * @author santosh
 *
 */
public class KErrorHandler implements KafkaListenerErrorHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(KErrorHandler.class);
	
	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
		LOGGER.info("Handling error for -Message: {}, -Headers [{}], -exception: {}",message.getPayload(), message.getHeaders(), e.getMessage());
		LOGGER.error(null,e);
		return null;
	}

}
