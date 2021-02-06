package ir.saeed.multi.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = { ApiRequestException.class })
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ApiException exception = new ApiException(e.getMessage(), ZonedDateTime.now(), status);

		return new ResponseEntity<>(exception, status);
	}
	
	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ApiException exception = new ApiException(e.getMessage(), ZonedDateTime.now(), status);

		return new ResponseEntity<>(exception, status);
	}
}
