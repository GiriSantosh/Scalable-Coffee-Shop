package net.santosh.event.source.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.event.source.backend.entity.EventStore;

@Repository
public interface EventRepository extends JpaRepository<EventStore, String> {}
