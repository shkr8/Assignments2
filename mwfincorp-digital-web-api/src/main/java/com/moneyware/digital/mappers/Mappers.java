package com.moneyware.digital.mappers;

import com.moneyware.digital.dto.FileUploadDTO;
import com.moneyware.digital.models.Customer;

public class Mappers {

	public static FileUploadDTO toFileUploadDTO(Customer cust) {
		return FileUploadDTO.builder().comment("ON DEMAND GENERIC INDEX FILE GENERATED")
				.timestamp(cust.getDocument().getUploadedAt()).custId(cust.getId())
				.docType(cust.getDocument().getDocType().toString()).filename(cust.getDocument().getFileName()).build();

	}

}
