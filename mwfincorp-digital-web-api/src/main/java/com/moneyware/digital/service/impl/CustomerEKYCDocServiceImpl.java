package com.moneyware.digital.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneyware.digital.dto.FileUploadDTO;
import com.moneyware.digital.enums.Status;
import com.moneyware.digital.mappers.Mappers;
import com.moneyware.digital.models.Customer;
import com.moneyware.digital.payloads.request.CustomerEKYCDocRequest;
import com.moneyware.digital.property.DocumentStorageProperty;
import com.moneyware.digital.repository.CustomerEKYCDocRepository;
import com.moneyware.digital.service.ICustomerEKYCDocService;
@Service
public class CustomerEKYCDocServiceImpl implements ICustomerEKYCDocService {
	
	@Autowired
	private CustomerEKYCDocRepository customerEKYCDocRepository;
	
	private final Path docStorageLocation;
	
	@Autowired
	public CustomerEKYCDocServiceImpl(DocumentStorageProperty documentStorageProperty) throws IOException {
		this.docStorageLocation = Paths.get(documentStorageProperty.getUploadDirectory()).toAbsolutePath().normalize();
		Files.createDirectories(this.docStorageLocation);
	}
	@Override
	public void saveCustomerEKYCDoc(CustomerEKYCDocRequest req){
		
		
	}
	
	
	public CompletableFuture<Boolean> performFileUploads() {
		List<Customer> list = this.getCustomersByStatus(Status.Completed.toString());
		for(Customer c : list) {
			FileUploadDTO f = Mappers.toFileUploadDTO(c);
			
		}
		return null;
		
	}
	@Override
	public List<Customer> getCustomers() {
		return customerEKYCDocRepository.findAll();
	}
	@Override
	public List<Customer> getCustomersByStatus(String status) {
		return customerEKYCDocRepository.findByStatus(status);
	}

}
