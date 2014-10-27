package com.tbt.testapi;

public class TestApiException extends Exception {
	String errorMessage;

	public TestApiException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String toString() {
		return errorMessage;
	}

	public String getMessage() {
		return errorMessage;
	}
}
