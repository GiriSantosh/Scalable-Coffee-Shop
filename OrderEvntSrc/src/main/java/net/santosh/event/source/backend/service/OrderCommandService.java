package net.santosh.event.source.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import net.santosh.event.source.backend.entity.CoffeeOrder;
import net.santosh.event.source.backend.entity.OrderStatus;
import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderCancelled;
import net.santosh.event.source.backend.events.entity.OrderPlaced;
import net.santosh.event.source.web.dto.OrderInfoDTO;
import net.santosh.event.source.web.dto.PlaceOrderInfoDto;

/**
 * @author santosh
 *
 */
@Component
public class OrderCommandService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private CoffeeOrders			  coffeeOrders;

	private MapperFacade			  mapper;

	@Autowired
	public OrderCommandService(MapperFactory mapperFactory) {
		mapper = mapperFactory.getMapperFacade();
	}

	/**
	 * converted to entity Object as we simply want to perform business logic on entity object.
	 * 
	 * @param placedOrder
	 * @throws Exception
	 */
	public void placeOrder(final PlaceOrderInfoDto placedOrder) throws Exception {
		//2. keeping method void, for consistency (either it should process it or throw exception)
		//if it throws, it should not be publishing event.

		CoffeeOrder order = placedOrder.toModel(CoffeeOrder.class, mapper);
		coffeeOrders.placeOrder(order);
		placedOrder.setOrderId(order.getId());

		//3. This have to be reliable once order is placed, it must publish the event.
		eventPublisher.publishEvent(new OrderPlaced(placedOrder));

	}

	public OrderInfoDTO getOrder(String orderId) throws Exception {
		CoffeeOrder coffeeOrder = coffeeOrders.getOrder(orderId);
		return coffeeOrder.toDTO(OrderInfoDTO.class, mapper);
	}

	public void cancelOrder(String orderId, String reason) throws Exception {
		coffeeOrders.updateOrderStatus(OrderStatus.CANCEL, orderId);
		eventPublisher.publishEvent(new OrderCancelled(orderId, reason));
	}

	public void acceptOrder(String orderId) throws Exception {
		coffeeOrders.updateOrderStatus(OrderStatus.ACCEPT, orderId);
		
		// can be cached for recently 10-50 orders request 
		CoffeeOrder order = coffeeOrders.getOrder(orderId);
		eventPublisher.publishEvent(new OrderAccepted(orderId, order.getBeanOrigin()));
	}
}
