package net.santosh.event.source.backend.config;

import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.backend.events.entity.OrderAcceptConfirmed;
import net.santosh.event.source.backend.events.entity.OrderBeansValidated;
import net.santosh.event.source.backend.events.entity.OrderFailedBeanNotAvailable;
import net.santosh.event.source.util.ObjectMapperUtil;
import net.santosh.event.source.util.StringUtil;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
import java.util.Map;

/**
 * @author santosh
 *
 */
@Deprecated
public class CoffeeEventDeSerializer extends JsonDeserializer<CoffeeEvent> {

	@Override
	public CoffeeEvent deserialize(String topic, byte[] data) {
		try {
			String eventData = new String(data);
			if (StringUtil.isValidJSONObject(eventData)) {
				Map<String, Object> rawData = ObjectMapperUtil.toMap(eventData);
				String event = String.valueOf(rawData.get("eventType"));

				switch (event) {
					case OrderBeansValidated.EVENT_NAME:
						return ObjectMapperUtil.toObject(new String(data), OrderBeansValidated.class);
					case OrderFailedBeanNotAvailable.EVENT_NAME:
						return ObjectMapperUtil.toObject(new String(data), OrderFailedBeanNotAvailable.class);
					case OrderAcceptConfirmed.EVENT_NAME:
						return ObjectMapperUtil.toObject(new String(data), OrderAcceptConfirmed.class);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
