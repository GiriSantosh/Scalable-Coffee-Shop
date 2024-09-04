package net.santosh.event.source.backend.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ma.glasnost.orika.MapperFacade;

/**
 * Super class for all DB models
 * 
 * @author santosh
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {

	protected static final Logger LOGGER		   = LoggerFactory.getLogger(BaseModel.class);

	private static final long	  serialVersionUID = -4300874321066494190L;

	public BaseModel(String id) {
		setId(id);
	}
	
	@Id
	@Column(columnDefinition = "VARCHAR(191)")
	private String				id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * convert into DTO object
	 * 
	 * @author santosh
	 * @param clazz
	 *            extends BaseDTO
	 * @param mapper
	 * @return
	 * @throws BaseConversionException
	 */
	public <S> S toDTO(Class<S> clazz, MapperFacade mapper) throws Exception {

		try {
			return mapper.map(this, clazz);
		} catch (SecurityException e) {
			LOGGER.error("BaseConversionException", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(null, e);
			throw e;
		}
	}
}