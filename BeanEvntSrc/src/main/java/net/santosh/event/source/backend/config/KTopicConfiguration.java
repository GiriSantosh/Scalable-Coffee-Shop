package net.santosh.event.source.backend.config;

import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;
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
	public NewTopic orderBeansValidatedTopic() {
		return new NewTopic(OrderBeansValidated.EVENT_NAME, 1, (short) 1);
	}

	@Bean
	public NewTopic orderFailedBeanNotAvailableTopic() {
		return new NewTopic(OrderFailedBeanNotAvailable.EVENT_NAME, 1, (short) 1);
	}

	@Bean
	public NewTopic orderAcceptConfirmedTopic() {
		return new NewTopic(OrderAcceptConfirmed.EVENT_NAME, 1, (short) 1);
	}

}
