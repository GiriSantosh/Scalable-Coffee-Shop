package net.santosh.event.source.backend.events.listener;

import net.santosh.event.source.backend.events.control.KEventProducer;
import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderCancelled;
import net.santosh.event.source.backend.events.entity.OrderPlaced;
import net.santosh.event.source.backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

	@Autowired(required = false)
	private KEventProducer eventProducer;

	@Autowired
	private EventService  eventService;

	@Async
	@EventListener
	public void orderPlaced(OrderPlaced orderPlaced) throws Exception {
		eventService.persistEvent(orderPlaced);

		eventProducer.send(OrderPlaced.EVENT_NAME, orderPlaced);
	}

	@EventListener
	public void cancelOrder(OrderCancelled orderCancelled) throws Exception {
		eventService.persistEvent(orderCancelled);
		/** also we can send notification on UI */
		//TODO: send notification on UI
	}

	@EventListener
	public void acceptOrder(OrderAccepted orderAccepted) throws Exception {
		eventService.persistEvent(orderAccepted);
		
		eventProducer.send(OrderAccepted.EVENT_NAME, orderAccepted);
	}
}
