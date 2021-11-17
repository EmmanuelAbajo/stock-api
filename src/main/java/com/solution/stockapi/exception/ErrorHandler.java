package com.solution.stockapi.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MethodNotAllowedException;

@ControllerAdvice
public class ErrorHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	protected ResponseEntity<Error> handleUnprosseasableMsgException(HttpMessageNotReadableException e,
			HttpServletResponse response) {
		logger.error(e.toString());
		return buildResponse(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
	}

	@ExceptionHandler(value = StockNotFoundException.class)
	protected ResponseEntity<Error> handleException(StockNotFoundException e, HttpServletRequest request) {
		logger.error(e.toString());
		return buildResponse(HttpStatus.NOT_FOUND, e.getMessage());
	}

	@ExceptionHandler(value = MethodNotAllowedException.class)
	protected ResponseEntity<Error> handleException(MethodNotAllowedException e, HttpServletRequest request) {
		logger.error(e.toString());
		return buildResponse(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage());
	}

	@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<Error> handleException(HttpRequestMethodNotSupportedException e,
			HttpServletRequest request) {
		logger.error(e.toString());
		return buildResponse(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage());
	}

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Error> handleException(Exception e) {
		logger.error(e.toString());
		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}

	private ResponseEntity<Error> buildResponse(HttpStatus status, String message) {
		return new ResponseEntity<Error>(new Error(status, message), status);
	}

}

class Error {
	private HttpStatus status;
	private String message;
	private LocalDateTime timestamp;

	public Error(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
