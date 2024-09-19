package net.santosh.event.source.web;

import net.santosh.event.source.backend.service.OrderCommandService;
import net.santosh.event.source.web.dto.OrderInfoDTO;
import net.santosh.event.source.web.dto.PlaceOrderInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
@Validated
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

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
        LOGGER.info("returning order for id: {}", orderId);
        return ResponseEntity.ok(commandService.getOrder(orderId));
    }
}
