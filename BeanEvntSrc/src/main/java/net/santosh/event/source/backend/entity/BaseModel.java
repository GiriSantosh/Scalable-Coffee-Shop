package net.santosh.event.source.backend.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Super class for all DB models
 *
 * @author santosh
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseModel.class);
    private static final long serialVersionUID = -4300874321066494190L;

    private ObjectMapper objectMapper = new ObjectMapper(); // Create an instance of ObjectMapper

    public BaseModel(String id) {
        setId(id);
    }

    @Id
    @Column(columnDefinition = "VARCHAR(191)")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * convert into DTO object
     *
     * @param clazz extends BaseDTO
     * @param clazz
     * @return
     * @author santosh
     */
    public <S> S toDTO(Class<S> clazz) {
        try {
            return objectMapper.convertValue(this, clazz);
        } catch (Exception e) {
            LOGGER.error("Conversion error", e);
        }
        return null;
    }
}