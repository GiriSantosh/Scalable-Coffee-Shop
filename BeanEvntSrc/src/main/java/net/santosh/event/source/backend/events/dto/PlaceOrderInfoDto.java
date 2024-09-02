package net.santosh.event.source.backend.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceOrderInfoDto {

	private String orderId;

	private String beanOrigin;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBeanOrigin() {
		return beanOrigin;
	}

	public void setBeanOrigin(String beanOrigin) {
		this.beanOrigin = beanOrigin;
	}

}
