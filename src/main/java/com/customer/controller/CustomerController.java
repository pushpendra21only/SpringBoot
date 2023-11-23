// Step 5: Creating Rest Controller CustomerController which
// defines various API's.
package com.customer.controller;

// Importing required packages
import com.customer.exception.CustomerAlreadyExistsException;
import com.customer.exception.ErrorResponse;
import com.customer.model.Customer;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired private CustomerService customerService;

	// Get Customer by Id
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable("id") Long id)
	{
		return customerService.getCustomer(id);
	}

	// Add new Customer
	@PostMapping("/addCustomer")
	public String
	addcustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}

	// Update Customer details
	@PutMapping("/updateCustomer")
	public String
	updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}

	// Exception Handler method added in CustomerController to
// handle CustomerAlreadyExistsException exception
	@ExceptionHandler(value
			= CustomerAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse
	handleCustomerAlreadyExistsException(
			CustomerAlreadyExistsException ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),
				ex.getMessage());
	}


}
