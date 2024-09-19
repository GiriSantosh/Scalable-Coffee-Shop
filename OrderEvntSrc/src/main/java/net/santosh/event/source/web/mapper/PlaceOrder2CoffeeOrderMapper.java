package net.santosh.event.source.web.mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import net.santosh.event.source.backend.entity.CoffeeOrder;
import net.santosh.event.source.web.dto.PlaceOrderInfoDto;
import org.springframework.stereotype.Component;

@Component
public class PlaceOrder2CoffeeOrderMapper implements OrikaMapperFactoryConfigurer{

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory
		.classMap(PlaceOrderInfoDto.class, CoffeeOrder.class)
		.byDefault()
		.mapNulls(false)
		.mapNullsInReverse(false)
		.customize(new CustomMapper<PlaceOrderInfoDto, CoffeeOrder>() {
			@Override
			public void mapBtoA(CoffeeOrder b, PlaceOrderInfoDto a, MappingContext context) {
				a.setOrderId(b.getId());
				super.mapBtoA(b, a, context);
			}
		})
		.register();
	}

}
