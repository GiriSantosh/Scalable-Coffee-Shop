package net.santosh.event.source.backend.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author santosh
 *
 */
@Entity
@Table(name = "event_store")
public class EventStore extends BaseModel {

	public EventStore() {
		super(UUID.randomUUID().toString());
		setCreatedDate(new Date());
	}

	public EventStore(EntityType entityType, String requestId, String eventType, String eventData, String referenceId) {
		this();
		setEntityType(entityType);
		setRequestId(requestId);
		setEventType(eventType);
		setEventData(eventData);
		setReferenceId(referenceId);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1053636931688236299L;

	@Column(name = "entity_type")
	@Enumerated(EnumType.STRING)
	private EntityType		  entityType;

	@Column(name = "event_id")
	private String			  requestId;

	@Column(name = "event_type")
	private String			  eventType;

	@Column(name = "reference_id")
	private String			  referenceId;

	@Column(name = "event_data", columnDefinition = "TEXT")
	private String			  eventData;

	@Column(name = "created")
	private Date			  createdDate;

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventData() {
		return eventData;
	}

	public void setEventData(String eventData) {
		this.eventData = eventData;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

}
