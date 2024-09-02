package net.santosh.event.source.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.entity.Bean;

@Component
public class BeanCommandService {

	@Autowired
	private BeanService bean;

	public void storeBean(Bean storeBean) {
		bean.storeBean(storeBean);
	}

}
