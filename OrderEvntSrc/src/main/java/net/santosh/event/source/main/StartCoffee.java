package net.santosh.event.source.main;

import org.springframework.boot.SpringApplication;

import net.santosh.event.source.CoffeeServiceConfiguration;

/**
 * @author santosh
 *
 */
public class StartCoffee {

	public static void main(String[] args) {
			SpringApplication.run(CoffeeServiceConfiguration.class, args);
	}
}
