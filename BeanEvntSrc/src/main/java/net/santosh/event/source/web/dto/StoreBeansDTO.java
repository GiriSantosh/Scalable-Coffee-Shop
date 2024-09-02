package net.santosh.event.source.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author santosh
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.ALWAYS)
public class StoreBeansDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6180824524328562650L;

	private String			  beanOrigin;

	/** number of stock */
	private Integer			  amount;

	public String getBeanOrigin() {
		return beanOrigin;
	}

	public void setBeanOrigin(String beanOrigin) {
		this.beanOrigin = beanOrigin;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
