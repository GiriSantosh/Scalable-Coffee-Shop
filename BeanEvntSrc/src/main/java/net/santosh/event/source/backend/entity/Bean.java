package net.santosh.event.source.backend.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author santosh
 *
 */
@Entity
@Table(name="beans")
public class Bean extends BaseModel{

	public Bean() {
		super(UUID.randomUUID().toString());
		setCreated(new Date());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9060815933695770330L;

	@Column(name = "name", columnDefinition = "VARCHAR(100)")
	private String name;
	
	@Column(name="stock")
	private int stock;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", columnDefinition = "DATETIME")
	private Date			  created;

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public int getStock() {
		return stock;
	}

	
	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public Date getCreated() {
		return created;
	}

	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
