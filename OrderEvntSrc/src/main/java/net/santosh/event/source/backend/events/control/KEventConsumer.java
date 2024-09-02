package net.santosh.event.source.backend.events.control;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;

/**
 * @author santosh
 *
 */
@Component
public class KEventConsumer {

	private static final Logger		  LOGGER = LoggerFactory.getLogger(KEventConsumer.class);

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@KafkaListener(topics = OrderBeansValidated.EVENT_NAME, errorHandler = "errorHandler",containerFactory="cfBeanValidated")
	public void listenOrderBeansValidatedTopic(@Payload(required = false) OrderBeansValidated orderBeanValidated) {

		if (Objects.isNull(orderBeanValidated)) {
			return;
		}

		LOGGER.info("Order ::Received Messasge in default group: " + orderBeanValidated.getReferenceId());

		eventPublisher.publishEvent(orderBeanValidated);
	}

	
	@KafkaListener(topics = OrderFailedBeanNotAvailable.EVENT_NAME, errorHandler = "errorHandler", containerFactory="cfBeanNotAvailable")
	public void listenOrderFailedBeanNotAvailableTopic(@Payload(required = false) OrderFailedBeanNotAvailable orderFailedBeanNotAvailable) {

		if (Objects.isNull(orderFailedBeanNotAvailable)) {
			return;
		}

		LOGGER.info("Order ::Received Messasge in default group: " + orderFailedBeanNotAvailable.getReferenceId());

		eventPublisher.publishEvent(orderFailedBeanNotAvailable);
	}
	
	
	@KafkaListener(topics = OrderAcceptConfirmed.EVENT_NAME, errorHandler = "errorHandler",containerFactory="kafkaListenerContainerFactory")
	public void listenOrderAcceptConfirmedTopic(@Payload(required = false) OrderAcceptConfirmed orderAcceptConfirmed) {

		if (Objects.isNull(orderAcceptConfirmed)) {
			return;
		}

		LOGGER.info("Order ::Received Messasge in default group: " + orderAcceptConfirmed.getReferenceId());

		eventPublisher.publishEvent(orderAcceptConfirmed);
	}
	
}
