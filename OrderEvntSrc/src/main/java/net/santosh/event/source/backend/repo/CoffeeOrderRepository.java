package net.santosh.event.source.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.santosh.event.source.backend.entity.CoffeeOrder;

/**
 * @author santosh
 *
 */
@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, String> {}
