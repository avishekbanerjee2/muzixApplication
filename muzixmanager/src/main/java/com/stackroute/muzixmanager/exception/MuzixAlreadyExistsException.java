package com.stackroute.muzixmanager.exception;

public class MuzixAlreadyExistsException extends Exception {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MuzixAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MuzixAlreadyExistsException [message=" + message + "]";
	}
}
