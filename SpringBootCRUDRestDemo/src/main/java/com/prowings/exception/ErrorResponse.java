package com.prowings.exception;

public class ErrorResponse {
	String message;
	String detail;
	String path;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message, String detail) {
		super();
		this.message = message;
		this.detail = detail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
