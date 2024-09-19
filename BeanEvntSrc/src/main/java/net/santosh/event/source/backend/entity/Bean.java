package net.santosh.event.source.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author santosh
 *
 */
@Entity
@Table(name="beans")
@JsonIgnoreProperties(ignoreUnknown = true)
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
