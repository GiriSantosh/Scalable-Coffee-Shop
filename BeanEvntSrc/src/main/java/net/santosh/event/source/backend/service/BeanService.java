package net.santosh.event.source.backend.service;

import net.santosh.event.source.backend.entity.Bean;

public interface BeanService {

	public void storeBean(Bean storeBean);

	public void validateBeans(String beanOrigin, String orderId);
	
	public void orderAccepted(String beanOrigin, String orderId);
}
