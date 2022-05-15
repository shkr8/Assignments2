package com.moneyware.digital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneyware.digital.models.Customer;

public interface CustomerEKYCDocRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByStatus(String status);
	

}
