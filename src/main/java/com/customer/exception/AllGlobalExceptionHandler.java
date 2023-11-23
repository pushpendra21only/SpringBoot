// Class to handle exception Globally
package com.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AllGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> allHandleException(Exception ex, WebRequest request)
	{
		ErrorResponse errors= new ErrorResponse(
			HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());

	return new ResponseEntity<ErrorResponse>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
