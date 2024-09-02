package net.santosh.event.source.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.santosh.event.source.backend.service.OrderCommandService;
import net.santosh.event.source.web.dto.OrderInfoDTO;
import net.santosh.event.source.web.dto.PlaceOrderInfoDto;

@RestController
@RequestMapping(value = "/order")
@Validated
public class Controller {

	@Autowired
	OrderCommandService commandService;

	@PostMapping
	//1st layer of validation
	public ResponseEntity<?> orderCoffee(@RequestBody(required = true) PlaceOrderInfoDto placedOrder) throws Exception {
		commandService.placeOrder(placedOrder);
		return ResponseEntity.status(HttpStatus.CREATED).body(placedOrder);
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderInfoDTO> getOrder(@PathVariable("orderId") String orderId) throws Exception {
		return ResponseEntity.ok(commandService.getOrder(orderId));
	}
}
