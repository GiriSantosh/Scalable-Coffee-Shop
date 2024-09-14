package net.santosh.event.source.backend.events.control;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderPlaced;

@Component
@Profile("!default")

public class KEventConsumer {
	
	@Value("${app.env}")
	private String envName;

	private static final Logger		  LOGGER = LoggerFactory.getLogger(KEventConsumer.class);

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@KafkaListener(topics = OrderPlaced.EVENT_NAME, errorHandler = "errorHandler", containerFactory="kafkaOrderPlacedListenerContainerFactory")
	public void listenOrderPlaced(@Payload(required = true) OrderPlaced orderPlaced) {

		if (Objects.isNull(orderPlaced)) {
			return;
		}

		LOGGER.info("ENV: {} BEAN :: Received OrderPlaced in default group: {}",envName, orderPlaced.getReferenceId());

		eventPublisher.publishEvent(orderPlaced);
	}

	@KafkaListener(topics = OrderAccepted.EVENT_NAME, errorHandler = "errorHandler", containerFactory="kafkaListenerContainerFactory")
	public void listenOrderAccepted(@Payload(required = true) OrderAccepted orderAccepted) {

		if (Objects.isNull(orderAccepted)) {
			return;
		}

		LOGGER.info("ENV: {} BEAN :: Received OrderAccepted in default group: {}",envName, orderAccepted.getReferenceId());

		eventPublisher.publishEvent(orderAccepted);
	}
}
