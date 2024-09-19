package net.santosh.event.source.web.exception;

import net.santosh.event.source.backend.exception.UserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author santosh
 *
 */
@RestControllerAdvice
public class WebExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseMsg handleRootException(Exception e) {
		return new ResponseMsg(e.getLocalizedMessage());
	}

	@ExceptionHandler(UserException.class)
	public ResponseMsg handlerUserException(UserException u) {
		return new ResponseMsg(u.getLocalizedMessage());
	}

}
