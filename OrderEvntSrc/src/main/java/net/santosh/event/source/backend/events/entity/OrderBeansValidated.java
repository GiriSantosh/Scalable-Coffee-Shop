package net.santosh.event.source.backend.events.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.ObjectMapperUtil;

/**
 * part of coffee event
 * 
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBeansValidated extends CoffeeEvent {

	public static final String	EVENT_NAME = "OrderBeansValidated";

	private String				referenceId;

	public OrderBeansValidated() {
		super();
	}

	public OrderBeansValidated(final String orderId) {
		this.referenceId = orderId;
	}

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
