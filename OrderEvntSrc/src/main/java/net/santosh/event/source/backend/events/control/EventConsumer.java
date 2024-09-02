package net.santosh.event.source.backend.events.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;

@Component
@Profile("NONE")
public class EventConsumer {

	private static final Logger		  LOGGER = LoggerFactory.getLogger(EventConsumer.class);

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@JmsListener(destination = "OrderBeansValidated")
	public void beanValidated(OrderBeansValidated coffeeEvent) {
		LOGGER.info(coffeeEvent.toString());
		try {
			eventPublisher.publishEvent(coffeeEvent);
		} catch (Exception e) {
			LOGGER.error("beanValidated", e);
		}
	}

	@JmsListener(destination = "OrderFailedBeanNotAvailable")
	public void beanValidationFailed(OrderFailedBeanNotAvailable coffeeEvent) {
		LOGGER.info(coffeeEvent.toString());
		try {
			eventPublisher.publishEvent(coffeeEvent);
		} catch (Exception e) {
			LOGGER.error("beanValidationFailed", e);
		}
	}

	/**
	 * double checking when only 1 stock is left.
	 * @param coffeeEvent
	 */
	@JmsListener(destination = "OrderAcceptConfirmed")
	public void orderAfterConfirmed(OrderAcceptConfirmed coffeeEvent) {
		LOGGER.info(coffeeEvent.toString());
		try {
			eventPublisher.publishEvent(coffeeEvent);
		} catch (Exception e) {
			LOGGER.error("orderAfterConfirmed", e);
		}
	}
}
