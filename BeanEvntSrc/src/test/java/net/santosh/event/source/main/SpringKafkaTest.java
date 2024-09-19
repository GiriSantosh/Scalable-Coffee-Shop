package net.santosh.event.source.main;

import net.santosh.event.source.backend.entity.Bean;
import net.santosh.event.source.web.dto.StoreBeansDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SpringKafkaTest {

    @Autowired
    private ModelMapper mapper = new ModelMapper();


    @Before
    public void init() {
        mapper.addMappings(new PropertyMap<StoreBeansDTO, Bean>() {
            @Override
            protected void configure() {
                map().setName(source.getBeanOrigin()); // Map beanOrigin to name
            }
        });

    }

    @Test
    public void testMapping() throws Exception {
        StoreBeansDTO beansDTO = new StoreBeansDTO();
        beansDTO.setBeanOrigin("Espresso");

        // Convert StoreBeansDTO to Bean using ObjectMapper
        Bean destination = mapper.map(beansDTO, Bean.class);

        // Assert that the name is correctly mapped
        assertEquals("Espresso", destination.getName());
    }
}
