package com.solution.stockapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Unprocessable Request")
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	protected void handleUnprosseasableMsgException(HttpMessageNotReadableException e) {
		logger.error(e.toString());
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = StockNotFoundException.class)
	protected void handleException(StockNotFoundException e, HttpServletRequest request) {
		logger.error(e.toString());
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	protected void handleException(Exception e, HttpServletRequest request) {
		logger.error(e.toString());
	}

}
