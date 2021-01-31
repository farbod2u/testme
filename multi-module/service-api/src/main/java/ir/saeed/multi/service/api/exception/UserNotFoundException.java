package ir.saeed.multi.service.api.exception;

public class UserNotFoundException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3035772812497942007L;

	
	public UserNotFoundException(Integer userId) {
		super("User not found with id : " + userId.toString());	
	}
}
