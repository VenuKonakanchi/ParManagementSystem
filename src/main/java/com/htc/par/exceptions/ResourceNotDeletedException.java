/**
 * 
 */
package com.htc.par.exceptions;

/**
 *  Resource not deleted exception
 *
 */
@SuppressWarnings("serial")
public class ResourceNotDeletedException extends RuntimeException {

	public ResourceNotDeletedException() {
		super();
	}

	public ResourceNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotDeletedException(String message) {
		super(message);
	}

	public ResourceNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	

}

