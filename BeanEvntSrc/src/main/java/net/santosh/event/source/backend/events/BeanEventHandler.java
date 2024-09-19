package net.santosh.event.source.backend.events;

import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderPlaced;
import net.santosh.event.source.backend.service.BeanService;
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
public class BeanEventHandler {

	static final Logger logger = LoggerFactory.getLogger(BeanEventHandler.class);
	
	@Autowired
	private BeanService beanService;
	
	/**
	 * handle orderPlaced event published by bean consumer
	 * @param event
	 */
	@EventListener
	public void handle(OrderPlaced event) {
		logger.info("executing order placed event");
		logger.info(event.getReferenceId());
		
		beanService.validateBeans(event.getOrderInfo().getBeanOrigin(),event.getOrderInfo().getOrderId());
	}
	
	@EventListener
	public void handle(OrderAccepted event) {
		logger.info("executing order accepted event");
		logger.info(event.getOrderId());
		
		beanService.orderAccepted(event.getBeanOrigin(),event.getOrderId());
	}
}
