package com.prowings.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(RequestMappingException.class)
	public ErrorResponse handleMappingException(RequestMappingException e, WebRequest request) {
		ErrorResponse er = new ErrorResponse();
		er.setDetail(e.getLocalizedMessage());
		er.setMessage(e.getMessage());
		er.setPath("/request");
		return er;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorResponse handleNoSuchElementException(NoSuchElementException e, WebRequest request) {
		ErrorResponse er = new ErrorResponse();
		er.setDetail(e.getLocalizedMessage());
		er.setMessage(e.getMessage());
		er.setPath("/customer/{id}");
		return er;
	}
//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(CustomerNotFoundException.class)
//	public ErrorResponse handleCustomerNotFoundException(CustomerNotFoundException e, WebRequest request) {
//		ErrorResponse er = new ErrorResponse();
//		er.setDetail(e.getLocalizedMessage());
//		er.setMessage(e.getMessage());
//		er.setPath("/customer/{id}");
//		return er;
//	}

}
