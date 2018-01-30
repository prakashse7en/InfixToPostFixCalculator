package com.calci.exception;

public class InvalidCharacterFound extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCharacterFound(String message) {
        super(message);
    }
}
