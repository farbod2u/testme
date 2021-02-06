package ir.saeed.multi.exception;

public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9036761547309631883L;

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(Integer id) {
		super("Entity with ID " + id.toString() + " not found.");
	}

}
