package net.santosh.event.source.backend.events.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;

/**
 * @author santosh
 *
 */
public class OrderCancelled extends CoffeeEvent {

	public static final String EVENT_NAME = "OrderCancelled";

	private final String	   orderId;

	private final String	   reason;

	public OrderCancelled(String orderId, String reason) {
		this.orderId = orderId;
		this.reason = reason;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String getReferenceId() {
		return orderId;
	}

	@Override
	protected String eventType() {
		return EVENT_NAME;
	}

	@Override
	protected String toJson() throws JsonProcessingException {
		return ObjectMapperUtil.toString(this);
	}

}
