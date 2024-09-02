package net.santosh.event.source.backend.events.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderAcceptConfirmed extends CoffeeEvent {

	public static final String EVENT_NAME = "OrderAcceptConfirmed";

	private String			   orderId;

	public OrderAcceptConfirmed() {}

	public OrderAcceptConfirmed(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String getReferenceId() {
		if (Objects.isNull(this.orderId)) {
			System.out.println("GOTTCHA!!!! Order.");
		}
		return this.orderId;
	}

	@Override
	protected String eventType() {
		return EVENT_NAME;
	}

	@Override
	protected String toJson() throws JsonProcessingException {
		return ObjectMapperUtil.toString(this);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
