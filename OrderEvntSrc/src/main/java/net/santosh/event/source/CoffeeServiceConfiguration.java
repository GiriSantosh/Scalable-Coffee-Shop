package net.santosh.event.source;

import net.santosh.event.source.backend.config.OrderBackEndConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author santosh
 *
 */
@SpringBootApplication
@Import(OrderBackEndConfiguration.class)
public class CoffeeServiceConfiguration {
	
}
