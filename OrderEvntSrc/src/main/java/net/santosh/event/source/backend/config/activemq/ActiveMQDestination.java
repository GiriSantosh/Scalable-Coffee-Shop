package net.santosh.event.source.backend.config.activemq;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;

/**
 * @author santosh
 *
 */
public class ActiveMQDestination {

	public static Destination orderPlacedQueue() {
		return new ActiveMQQueue("OrderPlaced");
	}

	public static Destination orderAccepted() {
		return new ActiveMQQueue("OrderAccepted");
	}
}
