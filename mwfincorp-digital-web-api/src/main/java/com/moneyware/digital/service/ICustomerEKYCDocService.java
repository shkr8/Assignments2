package com.moneyware.digital.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.moneyware.digital.models.Customer;
import com.moneyware.digital.payloads.request.CustomerEKYCDocRequest;

public interface ICustomerEKYCDocService {
	
	/**
	 * Add an array of files
	 * 
	 * @param multipartFiles
	 * @throws NoSuchAlgorithmException
	 * @throws IOException 
	 */
	public void saveCustomerEKYCDoc(CustomerEKYCDocRequest req);
	
	public List<Customer> getCustomers();
	
	public List<Customer> getCustomersByStatus(String status);

}
