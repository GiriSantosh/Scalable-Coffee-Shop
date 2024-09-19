package net.santosh.event.source.main;

import net.santosh.event.source.CoffeeServiceConfiguration;
import org.springframework.boot.SpringApplication;

/**
 * @author santosh
 *
 */
public class StartCoffee {

	public static void main(String[] args) {
			SpringApplication.run(CoffeeServiceConfiguration.class, args);
	}
}
