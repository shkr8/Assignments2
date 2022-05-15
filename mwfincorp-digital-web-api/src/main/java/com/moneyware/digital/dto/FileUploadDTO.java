package com.moneyware.digital.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class FileUploadDTO {
	
	private Long custId;
	private String comment;
	private Date timestamp;
	
	private String docType;
	private String filename;
	

}
