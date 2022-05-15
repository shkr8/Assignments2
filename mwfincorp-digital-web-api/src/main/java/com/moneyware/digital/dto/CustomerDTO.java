package com.moneyware.digital.dto;

import com.moneyware.digital.enums.Status;
import com.moneyware.digital.models.Document;

import lombok.Data;
@Data
public class CustomerDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Document document;
	private Status status;
	

}
