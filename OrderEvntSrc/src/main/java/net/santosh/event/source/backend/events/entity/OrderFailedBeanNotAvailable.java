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
public class OrderFailedBeanNotAvailable extends CoffeeEvent {

	public static final String	EVENT_NAME = "OrderFailedBeanNotAvailable";

	private String		referenceId;

	public OrderFailedBeanNotAvailable() {
		super();
	}
	
	public OrderFailedBeanNotAvailable(String orderId) {
		this.referenceId = orderId;
	}

	/**
	 * get order Id
	 */
	@Override
	public String getReferenceId() {
		return referenceId;
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
