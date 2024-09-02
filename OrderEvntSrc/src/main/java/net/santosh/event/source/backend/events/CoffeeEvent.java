package net.santosh.event.source.backend.events;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import net.santosh.event.source.backend.common.FieldConstant;
import net.santosh.event.source.backend.entity.EntityType;
import net.santosh.event.source.backend.entity.EventStore;

/**
 * @author santosh
 *
 */
public abstract class CoffeeEvent {

	public abstract String getReferenceId();

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FieldConstant.DATE_24_HR_PATTERN)
	private final Date instant;

	public CoffeeEvent() {
		instant = new Date();
	}

	public CoffeeEvent(final Date instant) {
		Objects.requireNonNull(instant);
		this.instant = instant;
	}

	public Date getInstant() {
		return instant;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final CoffeeEvent that = (CoffeeEvent) o;

		return instant.equals(that.instant);
	}

	@Override
	public int hashCode() {
		return instant.hashCode();
	}

	public EventStore toEventStore() throws JsonProcessingException {
		/** UUID.randomUUID().toString() will be context's request Id */
		return new EventStore(EntityType.ORDER, UUID.randomUUID().toString(), eventType(), toJson(), getReferenceId());
	}

	@JsonProperty("event")
	protected abstract String eventType();

	protected abstract String toJson() throws JsonProcessingException;
}
