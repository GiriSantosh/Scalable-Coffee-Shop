package net.santosh.event.source.backend.service;

import net.santosh.event.source.backend.entity.CoffeeOrder;
import net.santosh.event.source.backend.entity.OrderStatus;
import net.santosh.event.source.backend.exception.BusinessValidationException;
import net.santosh.event.source.backend.repo.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author santosh
 *
 */
@Service
public class CoffeeOrdersImpl implements CoffeeOrders {

	@Autowired
	private CoffeeOrderRepository coffeeOrderRepo;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void placeOrder(CoffeeOrder orderInfo) throws Exception {
		//4. Business logic and should throws exception if violates.

		if (null == orderInfo.getBeanOrigin()) {
			throw new BusinessValidationException("no bean origin is provided.");
		}

		orderInfo.setStatus(OrderStatus.PLACE);
		coffeeOrderRepo.save(orderInfo);
	}

	@Override
	public CoffeeOrder getOrder(String orderId) throws Exception {
		return coffeeOrderRepo.findById(orderId).orElseThrow(() -> new BusinessValidationException("No Order found with given Id."));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateOrderStatus(OrderStatus orderStatus, String orderId) throws Exception {
		CoffeeOrder order = getOrder(orderId);

		order.setStatus(orderStatus);
		coffeeOrderRepo.save(order);
	}
}
