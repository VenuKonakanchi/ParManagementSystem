/**
 * 
 */
package com.htc.par.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.htc.par.exceptions.ResourceDuplicateException;
import com.htc.par.exceptions.ResourceNotCreatedException;
import com.htc.par.exceptions.ResourceNotDeletedException;
import com.htc.par.exceptions.ResourceNotFoundException;
import com.htc.par.exceptions.ResourceNotUpdatedException;
import com.htc.par.to.ResponseException;

/**
 * Global exception handler for all controller in the project
 *
 */

@ControllerAdvice
public class PARExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ResourceNotFoundException.class })
	public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ ResourceNotDeletedException.class })
	public final ResponseEntity<Object> handleResourceNotDeletedException(ResourceNotDeletedException ex,
			WebRequest request) {
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ ResourceNotCreatedException.class })
	public final ResponseEntity<Object> handleResourceNotCreatedException(ResourceNotCreatedException ex,
			WebRequest request) {
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.GONE);
	}

	@ExceptionHandler({ ResourceNotUpdatedException.class })
	public final ResponseEntity<Object> handleResourceNotUpdatedException(ResourceNotUpdatedException ex,
			WebRequest request) {
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.GONE);
	}

	@ExceptionHandler({ ResourceDuplicateException.class })
	public final ResponseEntity<Object> handleResourceDuplicateException(ResourceDuplicateException ex,
			WebRequest request) {
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.CONFLICT);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return generateResponseEntity("Validation Failed", ex.getBindingResult().toString(), HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<Object> generateResponseEntity(String message, String description, HttpStatus httpStatus) {
		ResponseException responseException = new ResponseException(new Date(), message, description);
		return new ResponseEntity<Object>(responseException, httpStatus);
	}
}
