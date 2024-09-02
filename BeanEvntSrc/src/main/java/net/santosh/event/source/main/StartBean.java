package net.santosh.event.source.main;

import org.springframework.boot.SpringApplication;

import net.santosh.event.source.BeanServiceConfiguration;

/**
 * @author santosh
 *
 */
public class StartBean {

	public static void main(String[] args) {
		SpringApplication.run(BeanServiceConfiguration.class, args);
	}
}
