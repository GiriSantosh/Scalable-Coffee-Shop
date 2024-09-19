package net.santosh.event.source.backend.events.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;

/**
 * part of coffee event
 * 
 * @author santosh
 *
 */
public class OrderBeansValidated extends CoffeeEvent {

	public static final String EVENT_NAME	= "OrderBeansValidated";

	private final String	   orderId;

	public OrderBeansValidated(final String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String getReferenceId() {
		return orderId;
	}

	@Override
	public String eventType() {
		return EVENT_NAME;
	}

	@Override
	protected String toJson() throws JsonProcessingException {
		return ObjectMapperUtil.toString(this);
	}

}
