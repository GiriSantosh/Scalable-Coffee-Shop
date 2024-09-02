package net.santosh.event.source.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import net.santosh.event.source.backend.entity.Bean;
import net.santosh.event.source.backend.service.BeanCommandService;
import net.santosh.event.source.web.dto.StoreBeansDTO;

/**
 * @author santosh
 *
 */
@RestController
@RequestMapping("/bean")
@Validated
public class Controller {

	@Autowired
	private BeanCommandService commandService;
	
	private MapperFacade		mapper;
	
	@Autowired
	public Controller(MapperFactory mapperFactory) {
		mapper = mapperFactory.getMapperFacade();
	}
	
	@PostMapping
	public ResponseEntity<?> addBean(@RequestBody(required=true) StoreBeansDTO storeBean) throws Exception{
		Bean bean = storeBean.toModel(Bean.class, mapper);
		
		commandService.storeBean(bean);
		return ResponseEntity.ok("Bean added.");
	}
}
