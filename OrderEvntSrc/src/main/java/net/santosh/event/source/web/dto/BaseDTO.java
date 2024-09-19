package net.santosh.event.source.web.dto;

import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author santosh
 *
 */
public abstract class BaseDTO implements Serializable{

	private static final Logger	LOGGER			 = LoggerFactory.getLogger(BaseDTO.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5597695922984946927L;

	/**
	 * converts to Model entity object
	 * 
	 * @note beanUtils look for exact name during model conversion
	 * @param clazz
	 * @return
	 * @throws DTOConversionException
	 */
	public <T> T toModel(Class<T> clazz, MapperFacade mapper) throws Exception {
		try {
			return mapper.map(this, clazz);
		} catch (Exception e) {
			LOGGER.error(null, e);
			throw new Exception(
				String.format("Error converting to class %s, message %s",clazz.getTypeName(),e.getLocalizedMessage()));
		}
	}
}
