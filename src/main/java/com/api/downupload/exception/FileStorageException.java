package com.api.downupload.exception;


public class FileStorageException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FileStorageException(String message) {
		super();
		this.message = message;
	}
	
	
}
