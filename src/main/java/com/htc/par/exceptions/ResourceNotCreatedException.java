/**
 * 
 */
package com.htc.par.exceptions;


@SuppressWarnings("serial")
public class ResourceNotCreatedException extends RuntimeException {

	public ResourceNotCreatedException() {
		super();
	}

	public ResourceNotCreatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotCreatedException(String message) {
		super(message);
	}

	public ResourceNotCreatedException(Throwable cause) {
		super(cause);
	}

	
}