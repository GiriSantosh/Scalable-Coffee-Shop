package net.santosh.event.source.backend.config;

import net.santosh.event.source.web.dto.StoreBeansDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Define a property map for custom field mapping
        modelMapper.addMappings(new PropertyMap<StoreBeansDTO, net.santosh.event.source.backend.entity.Bean>() {
            @Override
            protected void configure() {
                map().setName(source.getBeanOrigin());
                map().setStock(source.getQty());
            }
        });

        return modelMapper;
    }
}
