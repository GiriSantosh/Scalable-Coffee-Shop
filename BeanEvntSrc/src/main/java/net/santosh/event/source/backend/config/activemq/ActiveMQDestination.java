package net.santosh.event.source.backend.config.activemq;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;

/**
 * @author santosh
 *
 */
public class ActiveMQDestination {

	public static Destination orderBeansValidated() {
		return new ActiveMQQueue("OrderBeansValidated");
	}
	
	public static Destination orderFailedBeanNotAvailable() {
		return new ActiveMQQueue("OrderFailedBeanNotAvailable");
	}

	public static Destination orderAcceptConfirmed() {
		return new ActiveMQQueue("OrderAcceptConfirmed");
	}
}
