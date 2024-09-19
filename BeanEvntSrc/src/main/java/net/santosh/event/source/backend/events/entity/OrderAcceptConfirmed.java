package net.santosh.event.source.backend.events.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;

import java.util.Objects;

/**
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderAcceptConfirmed extends CoffeeEvent {

	public static final String	EVENT_NAME = "OrderAcceptConfirmed";

	private final String		orderId;

	public OrderAcceptConfirmed(final String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String getReferenceId() {
		if(Objects.isNull(this.orderId)) {
			System.out.println("GOTTCHA!!!! BEAN.");
		}
		return this.orderId;
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

	
}
