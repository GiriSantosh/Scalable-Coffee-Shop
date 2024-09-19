package net.santosh.event.source.main;

import net.santosh.event.source.BeanServiceConfiguration;
import org.springframework.boot.SpringApplication;

/**
 * @author santosh
 *
 */
public class StartBean {

	public static void main(String[] args) {
		SpringApplication.run(BeanServiceConfiguration.class, args);
	}
}
