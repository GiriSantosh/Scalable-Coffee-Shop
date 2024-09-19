package net.santosh.event.source.backend.config;

import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderCancelled;
import net.santosh.event.source.backend.events.entity.OrderPlaced;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("!default")
public class KTopicConfiguration {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServers;

	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		return new KafkaAdmin(configs);
	}

	@Bean
	public NewTopic orderPlacedTopic() {
		return new NewTopic(OrderPlaced.EVENT_NAME, 3, (short) 1);
	}

	@Bean
	public NewTopic orderAcceptedTopic() {
		return new NewTopic(OrderAccepted.EVENT_NAME, 1, (short) 1);
	}
	
	@Bean
	public NewTopic orderCancelledTopic() {
		return new NewTopic(OrderCancelled.EVENT_NAME, 2, (short) 1);
	}
}
