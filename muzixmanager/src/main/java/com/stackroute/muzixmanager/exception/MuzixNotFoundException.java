package com.stackroute.muzixmanager.exception;

public class MuzixNotFoundException extends Exception {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MuzixNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MuzixNotFoundException [message=" + message + "]";
	}
}
