package ir.saeed.multi;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {

	private String message;
	// private Throwable throwable;
	private ZonedDateTime timestamp;
	private HttpStatus httpStatus;

	public ApiException(String message, ZonedDateTime timestamp, HttpStatus httpStatus) {
		super();
		this.message = message;
		// this.throwable = throwable;
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

//	public Throwable getThrowable() {
//		return throwable;
//	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
