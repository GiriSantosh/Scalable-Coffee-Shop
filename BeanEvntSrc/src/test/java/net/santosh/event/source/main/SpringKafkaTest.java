package net.santosh.event.source.main;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.santosh.event.source.backend.events.control.KEventConsumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaTest {

	@Autowired
	private KEventConsumer consumer;

	
}
