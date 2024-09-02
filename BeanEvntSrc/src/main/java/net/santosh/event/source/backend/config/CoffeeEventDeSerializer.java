package net.santosh.event.source.backend.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.kafka.support.serializer.JsonDeserializer;

import net.santosh.event.source.backend.events.CoffeeEvent;
import net.santosh.event.source.backend.events.entity.OrderAccepted;
import net.santosh.event.source.backend.events.entity.OrderPlaced;
import net.santosh.event.source.util.ObjectMapperUtil;
import net.santosh.event.source.util.StringUtil;

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
				String event = String.valueOf(rawData.get("event"));

				switch (event) {
					case OrderPlaced.EVENT_NAME:
						return ObjectMapperUtil.toObject(new String(data), OrderPlaced.class);
					case OrderAccepted.EVENT_NAME:
						return ObjectMapperUtil.toObject(new String(data), OrderAccepted.class);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
