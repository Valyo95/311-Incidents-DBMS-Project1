package com.incidents.exceptions;

public class SerializationFailedException extends SystemException {

	private static final long serialVersionUID = -824275985094104633L;

	public SerializationFailedException() {
		super();
	}

	public SerializationFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SerializationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SerializationFailedException(String message) {
		super(message);
	}

	public SerializationFailedException(Throwable cause) {
		super(cause);
	}

}
