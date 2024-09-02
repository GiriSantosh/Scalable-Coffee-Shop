package net.santosh.event.source.backend.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;

/**
 * @author santosh
 *
 */
@Configuration
public class KConsumerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServers;

	@Value("${kafka.group:order-service}")
	private String groupId;

	@Bean
	public Map<String, Object> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return props;
	}

	@Bean
	public ConsumerFactory<String, OrderBeansValidated> orderBeansValidatedFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerFactory(), new StringDeserializer(), new JsonDeserializer<OrderBeansValidated>(OrderBeansValidated.class));
	}

	@Bean("cfBeanValidated")
	public ConcurrentKafkaListenerContainerFactory<String, OrderBeansValidated> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrderBeansValidated> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(orderBeansValidatedFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, OrderFailedBeanNotAvailable> orderFailedBeanNotAvailableFactory() {
		return new DefaultKafkaConsumerFactory<>(
			consumerFactory(),
			new StringDeserializer(),
			new JsonDeserializer<OrderFailedBeanNotAvailable>(OrderFailedBeanNotAvailable.class));
	}

	@Bean("cfBeanNotAvailable")
	public ConcurrentKafkaListenerContainerFactory<String, OrderFailedBeanNotAvailable> kafkaListenerOrderFailedBeanNotAvailableContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrderFailedBeanNotAvailable> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(orderFailedBeanNotAvailableFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, OrderAcceptConfirmed> orderAcceptConfirmedFactory() {
		return new DefaultKafkaConsumerFactory<>(
			consumerFactory(),
			new StringDeserializer(),
			new JsonDeserializer<OrderAcceptConfirmed>(OrderAcceptConfirmed.class));
	}

	@Bean("kafkaListenerContainerFactory")
	public ConcurrentKafkaListenerContainerFactory<String, OrderAcceptConfirmed> kafkaListenerOrderAcceptConfirmedContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, OrderAcceptConfirmed> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(orderAcceptConfirmedFactory());
		return factory;
	}

	@Bean
	public KafkaListenerErrorHandler errorHandler() {
		return new KErrorHandler();
	}

}