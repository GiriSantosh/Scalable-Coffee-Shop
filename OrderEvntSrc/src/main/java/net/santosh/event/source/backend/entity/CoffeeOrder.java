package net.santosh.event.source.backend.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

/**
 * ASSUMING ONLY 1 QTY will BE REQUESTED
 * @author santosh
 *
 */
@Entity
@Table(name = "orders")
public class CoffeeOrder extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7444120825736605073L;
	
	public CoffeeOrder() {
		super(UUID.randomUUID().toString());
		setCreated(new Date());
	}

	@Column(name = "bean_origin", length = 50)
	private String			  beanOrigin;

	@Column(name = "coffee_type", length = 100)
	@Enumerated(EnumType.STRING)
	private CoffeeType		  coffeeType;

	@Column(name = "status", length = 100)
	@Enumerated(EnumType.STRING)
	private OrderStatus		  status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", columnDefinition = "DATETIME")
	private Date			  created;

	public String getBeanOrigin() {
		return beanOrigin;
	}

	public void setBeanOrigin(String beanOrigin) {
		this.beanOrigin = beanOrigin;
	}

	public CoffeeType getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(CoffeeType coffeeType) {
		this.coffeeType = coffeeType;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
