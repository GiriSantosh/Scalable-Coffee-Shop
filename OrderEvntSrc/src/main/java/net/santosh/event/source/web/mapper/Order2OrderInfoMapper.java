package net.santosh.event.source.web.mapper;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import net.santosh.event.source.backend.entity.CoffeeOrder;
import net.santosh.event.source.web.dto.OrderInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class Order2OrderInfoMapper implements OrikaMapperFactoryConfigurer{

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory
		.classMap(OrderInfoDTO.class, CoffeeOrder.class)
		.byDefault()
		.mapNulls(false)
		.mapNullsInReverse(false)
		.field("orderId", "id")
		.register();
	}

}
