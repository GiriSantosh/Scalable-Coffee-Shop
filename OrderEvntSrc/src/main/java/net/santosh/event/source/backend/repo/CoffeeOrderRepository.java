package net.santosh.event.source.backend.repo;

import net.santosh.event.source.backend.entity.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author santosh
 *
 */
@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, String> {}
