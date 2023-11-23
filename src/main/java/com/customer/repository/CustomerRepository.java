// Step 2: Creating a Repository
// Interface extending
// JpaRepository
package com.customer.repository;

import com.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
	extends JpaRepository<Customer, Long> {
}
