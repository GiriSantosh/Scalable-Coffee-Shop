package net.santosh.event.source.backend.events.control;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.util.StringUtil;

@Component
@Profile("!default")

public class KEventProducer {

	private static final Logger				   LOGGER = LoggerFactory.getLogger(KEventProducer.class);

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void send(String topic, CoffeeEvent messageToDrop) {

		if (StringUtil.nullOrEmpty(topic) || Objects.isNull(messageToDrop)) {
			return;
		}

		LOGGER.info("publishing message");
		kafkaTemplate.send(topic, messageToDrop);

		LOGGER.info("message published!");
	}
}
