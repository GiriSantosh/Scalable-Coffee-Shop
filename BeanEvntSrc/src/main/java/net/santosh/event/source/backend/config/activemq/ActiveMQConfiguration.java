package net.santosh.event.source.backend.config.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


/**
 * @author santosh
 *
 */
@Configuration
@Profile("NONE")
public class ActiveMQConfiguration {

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
		activeMQConnectionFactory.setUserName("admin");
		activeMQConnectionFactory.setPassword("admin");
		activeMQConnectionFactory.setMaxThreadPoolSize(2);

		return activeMQConnectionFactory;
	}

	@Bean(name = "activeMQJMS")
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
		jmsTemplate.setConnectionFactory(connectionFactory());

		return jmsTemplate;
	}

	@Bean
	// Serializes message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
