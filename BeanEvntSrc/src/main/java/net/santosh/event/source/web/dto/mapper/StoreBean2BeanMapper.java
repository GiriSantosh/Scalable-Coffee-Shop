package net.santosh.event.source.web.dto.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import net.santosh.event.source.backend.entity.Bean;
import net.santosh.event.source.web.dto.StoreBeansDTO;

/**
 * @author santosh
 *
 */
@Component
public class StoreBean2BeanMapper implements OrikaMapperFactoryConfigurer {

	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory
			.classMap(StoreBeansDTO.class, Bean.class)
			.byDefault()
			.mapNulls(false)
			.mapNullsInReverse(false)
			.field("beanOrigin", "name")
			.field("amount", "stock")
			.register();
	}

}
