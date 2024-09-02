package net.santosh.event.source.backend.service;

import net.santosh.event.source.backend.events.CoffeeEvent;

/**
 * @author santosh
 *
 */
public interface EventService {

	public void persistEvent(CoffeeEvent coffeeEvent) throws Exception;
}
