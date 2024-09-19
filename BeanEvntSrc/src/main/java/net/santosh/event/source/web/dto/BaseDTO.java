package net.santosh.event.source.web.dto;

import org.modelmapper.ModelMapper;

import java.io.Serializable;


/**
 * @author santosh
 */
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = -151021596907692528L;

    /**
     * converts to Model entity object
     *
     * @param clazz
     * @return
     * @note beanUtils look for exact name during model conversion
     */
    public <T> T toModel(Class<T> clazz, ModelMapper mapper) {
        return mapper.map(this, clazz);
    }
}
