package net.santosh.event.source.main;

import net.santosh.event.source.backend.events.control.KEventConsumer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringKafkaTest {

	@Autowired
	private KEventConsumer consumer;

	@Test
	public void testKafkaIntegration() {
		// Your test logic here
	}
}
