package com.moneyware.digital.payloads.request;

import lombok.Data;

@Data
public class CustomerEKYCDocRequest {
	
	private Long customerId;
	private byte[] document;
	private String docIdType;
	private String docType;

}
