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

	private String				orderId;

	private String				beanOrigin;

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

	public String getOrderId() {
		return orderId;
	}

	public void setBeanOrigin(String beanOrigin) {
		this.beanOrigin = beanOrigin;
	}

	public String getBeanOrigin() {
		return beanOrigin;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
