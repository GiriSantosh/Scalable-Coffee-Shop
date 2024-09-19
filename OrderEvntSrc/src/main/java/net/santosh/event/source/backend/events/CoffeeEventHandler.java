package net.santosh.event.source.backend.events;

import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;
import net.santosh.event.source.backend.service.EventService;
import net.santosh.event.source.backend.service.OrderCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * handles all the events that are being consumed from the queue.
 * @author santosh
 *
 */
@Component
public class CoffeeEventHandler {

	static final Logger logger = LoggerFactory.getLogger(CoffeeEventHandler.class);
	
	@Autowired
	private OrderCommandService orderService;
	
	@Autowired
	private EventService eventService;
	
	@EventListener
	public void beanValidationFailed(OrderFailedBeanNotAvailable orderFailed) throws Exception {
		// no need to capture the event's response twice, already being captured in Bean
		//eventService.persistEvent(orderPlaced);
		
		orderService.cancelOrder(orderFailed.getReferenceId(),"No beans of the origin were available");
	}
	
	@EventListener
	public void beanValidated(OrderBeansValidated orderValidated) throws Exception {
		// no need to capture the event's response twice, already being captured in Bean
		//eventService.persistEvent(orderPlaced);
		
		orderService.acceptOrder(orderValidated.getReferenceId());
	}
	
	@EventListener
	public void orderAcceptConfirmed(OrderAcceptConfirmed orderAccepted) throws Exception {
		// no need to capture the event's response twice, already being captured in Bean
		eventService.persistEvent(orderAccepted);
		
		//orderService.acceptOrder(orderAccepted.getReferenceId());
		//BroadCast to BARISTA (Coffee machine for further action)
	}
}
