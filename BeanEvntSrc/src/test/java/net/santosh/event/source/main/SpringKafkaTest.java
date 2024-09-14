package net.santosh.event.source.main;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.santosh.event.source.backend.entity.Bean;
import net.santosh.event.source.web.dto.StoreBeansDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SpringKafkaTest {

    private MapperFactory mapperFactory= new DefaultMapperFactory.Builder().build();

    @Autowired
    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Test
    public void testMapping() {
        StoreBeansDTO beansDTO = new StoreBeansDTO();
        beansDTO.setBeanOrigin("Espresso");
        Bean destination = mapper.map(beansDTO, Bean.class);
        assertEquals("Espresso", destination.getName());
    }
}
