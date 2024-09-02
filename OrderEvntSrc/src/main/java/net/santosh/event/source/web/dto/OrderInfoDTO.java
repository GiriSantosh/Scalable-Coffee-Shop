package net.santosh.event.source.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author santosh
 *
 */
public class OrderInfoDTO extends PlaceOrderInfoDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8827722417372670960L;

	@JsonProperty("order_status")
	private String			  status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
