package net.santosh.event.source.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import net.santosh.event.source.web.validation.IsValidCoffeeType;

/**
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class PlaceOrderInfoDto extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7679829072711121048L;

	private String			  orderId;

	private String			  beanOrigin;

	@IsValidCoffeeType
	private String			  coffeeType;

	public String getBeanOrigin() {
		return beanOrigin;
	}

	public void setBeanOrigin(String beanOrigin) {
		this.beanOrigin = beanOrigin;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
