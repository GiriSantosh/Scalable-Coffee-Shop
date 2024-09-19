package net.santosh.event.source.backend.events.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.backend.events.dto.PlaceOrderInfoDto;
import net.santosh.event.source.util.ObjectMapperUtil;

/**
 * event for order place
 * 
 * @author santosh
 * @instanceOf Coffee Event
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPlaced extends CoffeeEvent {

	public static final String EVENT_NAME = "OrderPlaced";

	private String			   referenceId;

	private PlaceOrderInfoDto  orderInfo;

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public PlaceOrderInfoDto getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(PlaceOrderInfoDto orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getReferenceId() {
		return referenceId;
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
