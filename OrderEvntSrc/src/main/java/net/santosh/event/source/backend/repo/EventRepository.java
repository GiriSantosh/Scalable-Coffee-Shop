package net.santosh.event.source.backend.repo;

import net.santosh.event.source.backend.entity.EventStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventStore, String> {}
