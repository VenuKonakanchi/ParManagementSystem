/**
 * 
 */
package com.htc.par.exceptions;

/**
 * Resource not updated exception
 *
 */
@SuppressWarnings("serial")
public class ResourceNotUpdatedException extends RuntimeException {

	public ResourceNotUpdatedException() {
		super();
	}

	public ResourceNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotUpdatedException(String message) {
		super(message);
	}

	public ResourceNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	

}
