package net.santosh.event.source.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/servicestatus")
@Validated
public class HealthServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthServiceController.class);

    @GetMapping
    public String getServiceStatus() {
        LOGGER.info("Order service health - {}", HttpStatus.OK);
        return "Order - " + HttpStatus.OK;
    }
}
