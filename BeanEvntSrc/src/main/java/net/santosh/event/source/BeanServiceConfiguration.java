package net.santosh.event.source;

import net.santosh.event.source.backend.config.BeanBackEndConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author santosh
 *
 */
@SpringBootApplication
@Import(BeanBackEndConfiguration.class)
public class BeanServiceConfiguration {

}
