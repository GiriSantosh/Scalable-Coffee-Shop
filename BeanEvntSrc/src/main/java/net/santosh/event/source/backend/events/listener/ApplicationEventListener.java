package net.santosh.event.source.backend.events.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.control.KEventProducer;
import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;
import net.santosh.event.source.backend.service.EventService;

@Component
public class ApplicationEventListener {

	@Autowired(required = false)
	private KEventProducer eventProducer;

	@Autowired
	private EventService   eventService;

	@EventListener
	public void orderBeansValidated(OrderBeansValidated beanStatus) throws Exception {
		eventService.persistEvent(beanStatus);

		eventProducer.send(OrderBeansValidated.EVENT_NAME, beanStatus);
	}

	@EventListener
	public void orderFailedBeanNotAvailable(OrderFailedBeanNotAvailable beanStatus) throws Exception {
		/** saving event on event store */
		eventService.persistEvent(beanStatus);

		eventProducer.send(OrderFailedBeanNotAvailable.EVENT_NAME, beanStatus);
	}

	@EventListener
	public void orderAcceptConfirmed(OrderAcceptConfirmed orderAcceptConfirmed) throws Exception {
		eventService.persistEvent(orderAcceptConfirmed);

		eventProducer.send(OrderAcceptConfirmed.EVENT_NAME, orderAcceptConfirmed);
	}
}
