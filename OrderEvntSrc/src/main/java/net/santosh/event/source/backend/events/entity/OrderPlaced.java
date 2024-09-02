package net.santosh.event.source.backend.events.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;
import net.santosh.event.source.web.dto.PlaceOrderInfoDto;

/**
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlaced extends CoffeeEvent {

	public static final String		EVENT_NAME = "OrderPlaced";

	private final PlaceOrderInfoDto	orderInfo;

	public OrderPlaced(final PlaceOrderInfoDto orderEntity) {
		this.orderInfo = orderEntity;
	}

	public OrderPlaced(final PlaceOrderInfoDto orderInfo, Date instant) {
		super(instant);
		this.orderInfo = orderInfo;
	}

	public PlaceOrderInfoDto getOrderInfo() {
		return orderInfo;
	}

	@Override
	public String eventType() {
		return EVENT_NAME;
	}

	@Override
	public String toJson() throws JsonProcessingException {
		return ObjectMapperUtil.toString(this);
	}

	@Override
	@JsonProperty("referenceId")
	public String getReferenceId() {
		return orderInfo.getOrderId();
	}

}
