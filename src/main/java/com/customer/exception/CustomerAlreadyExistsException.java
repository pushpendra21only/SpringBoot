// Step 3: Creating custom exception
// that can be thrown when
// user tries to add a customer
// that already exists
package com.customer.exception;

public class CustomerAlreadyExistsException
	extends RuntimeException {

	private String message;

	public CustomerAlreadyExistsException() {}

	public CustomerAlreadyExistsException(String msg)
	{
		super(msg);
		this.message = msg;
	}
}
