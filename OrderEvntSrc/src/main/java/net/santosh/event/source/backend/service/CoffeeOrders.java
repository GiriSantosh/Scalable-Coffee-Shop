package net.santosh.event.source.backend.service;

import net.santosh.event.source.backend.entity.CoffeeOrder;
import net.santosh.event.source.backend.entity.OrderStatus;

/**
 * @author santosh
 *
 */
public interface CoffeeOrders {

	/**
	 * persist order info on database after performing business logic
	 * 
	 * @param orderInfo
	 */
	public void placeOrder(final CoffeeOrder orderInfo) throws Exception;

	public CoffeeOrder getOrder(String orderId) throws Exception;

	public void updateOrderStatus(OrderStatus orderStatus, String orderId) throws Exception;
}
