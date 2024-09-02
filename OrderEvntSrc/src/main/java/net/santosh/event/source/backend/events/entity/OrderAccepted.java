package net.santosh.event.source.backend.events.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;

/**
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderAccepted extends CoffeeEvent {

	public static final String	EVENT_NAME = "OrderAccepted";

	private final String		orderId;

	private final String		beanOrigin;

	public OrderAccepted(String orderId, String beanOrigin) {
		this.orderId = orderId;
		this.beanOrigin = beanOrigin;
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

	public String getBeanOrigin() {
		return beanOrigin;
	}
	
	public String getOrderId() {
		return orderId;
	}
}
