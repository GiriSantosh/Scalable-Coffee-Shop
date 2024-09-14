package net.santosh.event.source.backend.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderPlaced;

/**
 * @author santosh
 *
 */
@Configuration
@Profile("!default")
public class KConsumerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServers;

	@Value("${kafka.group:bean-service}")
	private String groupId;

	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return props;
	}

	@Bean
	public ConsumerFactory<String, OrderPlaced> consumerPlacedFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<>(OrderPlaced.class));
	}

	@Bean("kafkaOrderPlacedListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, OrderPlaced> kafkaOrderPlacedListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrderPlaced> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerPlacedFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, OrderAccepted> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new JsonDeserializer<OrderAccepted>(OrderAccepted.class) {
			@Override
			public OrderAccepted deserialize(String topic, byte[] data) {
				// to ignore empty jsons and error loop
				try {
					return super.deserialize(topic, data);
				} catch (Exception e) {
					return null;
				}
			}
		});
	}

	@Bean("kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, OrderAccepted> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrderAccepted> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public KafkaListenerErrorHandler errorHandler() {
		return new KErrorHandler();
	}

}