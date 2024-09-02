package net.santosh.event.source.backend.events.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderPlaced;

@Component
@Profile("NONE")
public class EventConsumer {

	private static final Logger		  LOGGER = LoggerFactory.getLogger(EventConsumer.class);

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@JmsListener(destination = "OrderPlaced")
	public void orderPlaced(OrderPlaced orderPlaced) {
		LOGGER.info(orderPlaced.toString());

		try {
			//OrderPlaced orderPlaced = ObjectMapperUtil.toObject(json, OrderPlaced.class);
			eventPublisher.publishEvent(orderPlaced);

		} catch (Exception e) {
			LOGGER.error("orderPlaced", e);
		}
	}
	
	@JmsListener(destination="OrderAccepted")
	public void orderAccepted(OrderAccepted orderAccepted) {
		try {
			eventPublisher.publishEvent(orderAccepted);
		} catch (Exception e) {
			LOGGER.error("OrderAccepted", e);
		}
	}

}
