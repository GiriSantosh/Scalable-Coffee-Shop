package net.santosh.event.source.backend.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.santosh.event.source.backend.entity.Bean;
import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;
import net.santosh.event.source.backend.repo.BeanRepository;

/**
 * @author santosh
 *
 */
@Service
public class BeanServiceImpl implements BeanService {

	@Autowired
	private BeanRepository			  beanRepository;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Transactional(rollbackFor = Exception.class)
	public void storeBean(Bean storeBean) {
		beanRepository.save(storeBean);
	}

	public void validateBeans(String beanOrigin, String orderId) {
		if (Objects.nonNull(beanRepository.getRemainingStock(beanOrigin)) && beanRepository.getRemainingStock(beanOrigin) > 0) {
			eventPublisher.publishEvent(new OrderBeansValidated(orderId));
		} else {
			eventPublisher.publishEvent(new OrderFailedBeanNotAvailable(orderId));
		}
	}

	@Transactional
	public void orderAccepted(String beanOrigin, String orderId) {
		if (Objects.nonNull(beanRepository.getRemainingStock(beanOrigin)) && beanRepository.getRemainingStock(beanOrigin) > 0) {
			beanRepository.reduceOneQty(beanOrigin);
			eventPublisher.publishEvent(new OrderAcceptConfirmed(orderId));
		} else {
			eventPublisher.publishEvent(new OrderFailedBeanNotAvailable(orderId));
		}
	}

}
