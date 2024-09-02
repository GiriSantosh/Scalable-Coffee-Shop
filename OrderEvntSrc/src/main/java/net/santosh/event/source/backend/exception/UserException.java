package net.santosh.event.source.backend.exception;

/**
 * all end user exception must have given signature
 * 
 * @author santosh
 *
 */
public abstract class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5597765770745467525L;
	
	public UserException(String msg) {
		super(msg);
	}
}
