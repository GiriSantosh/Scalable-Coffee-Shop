package net.santosh.event.source;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import net.santosh.event.source.backend.config.BeanBackEndConfiguration;

/**
 * @author santosh
 *
 */
@SpringBootApplication
@Import(BeanBackEndConfiguration.class)
public class BeanServiceConfiguration {

}
