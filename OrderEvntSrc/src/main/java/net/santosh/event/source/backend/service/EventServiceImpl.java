package net.santosh.event.source.backend.service;

import net.santosh.event.source.backend.entity.EventStore;
import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.backend.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void persistEvent(CoffeeEvent coffeeEvent) throws Exception {
		EventStore eventStore = coffeeEvent.toEventStore();
		eventRepository.save(eventStore);
	}

}
