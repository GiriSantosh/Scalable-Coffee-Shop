package net.santosh.event.source.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.event.source.backend.entity.EventStore;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.backend.repo.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Transactional(rollbackFor = Exception.class)
	public void persistEvent(CoffeeEvent coffeeEvent) throws Exception {
		EventStore eventStore = coffeeEvent.toEventStore();
		eventRepository.save(eventStore);
	}

}
