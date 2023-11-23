// Class to handle exception Globally
package com.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({NoSuchCustomerExistsException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handleException(NoSuchCustomerExistsException ex)
	{
		return new ErrorResponse(
			HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler({CustomerAlreadyExistsException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handleException(CustomerAlreadyExistsException ex)
	{
		return new ErrorResponse(
				HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

}
