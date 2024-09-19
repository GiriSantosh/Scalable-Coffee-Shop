package net.santosh.event.source.backend.service;

import net.santosh.event.source.backend.entity.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class BeanCommandService {

	@Autowired
	private BeanService bean;

	public void storeBean(Bean storeBean) {
		if (StringUtils.hasLength(storeBean.getName())) {
			throw new RuntimeException("Empty Bean name or amount is not acceptable");
		}
		bean.storeBean(storeBean);
	}

}
