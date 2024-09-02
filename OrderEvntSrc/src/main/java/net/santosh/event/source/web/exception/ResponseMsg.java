package net.santosh.event.source.web.exception;

/**
 * @author santosh
 *
 */
public class ResponseMsg {

	private String message;

	public ResponseMsg(String message) {
		setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
