package net.santosh.event.source.backend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author santosh
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("net.santosh.event.source")
@EntityScan("net.santosh.event.source.backend.entity")
@EnableJpaRepositories("net.santosh.event.source.backend.repo")
public class BeanBackEndConfiguration {

}
