package net.santosh.event.source;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import net.santosh.event.source.backend.config.OrderBackEndConfiguration;

/**
 * @author santosh
 *
 */
@SpringBootApplication
@Import(OrderBackEndConfiguration.class)
public class CoffeeServiceConfiguration {
	
}
