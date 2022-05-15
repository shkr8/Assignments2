package com.moneyware.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneyware.digital.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
