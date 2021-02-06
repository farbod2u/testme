package ir.saeed.multi;

public class ApiRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3268188615005282290L;

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiRequestException(String message) {
		super(message);
	}
	
	

}
