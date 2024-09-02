package net.santosh.event.source.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import net.santosh.event.source.backend.entity.Bean;

/**
 * @author santosh
 *
 */
public interface BeanRepository extends JpaRepository<Bean, String> {

	/**
	 * returns remaining stock
	 * 
	 * @param beanOrigin
	 * @return
	 */
	@Query(nativeQuery = true, value = "select stock from beans where name=?1 limit 1")
	Integer getRemainingStock(String beanOrigin);

	@Modifying
	@Query(nativeQuery = true, value = "update beans set stock=stock-1 where name = ?1")
	void reduceOneQty(String beanOrigin);
}
