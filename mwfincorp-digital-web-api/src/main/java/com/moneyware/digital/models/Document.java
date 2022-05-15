package com.moneyware.digital.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.moneyware.digital.enums.DocIdType;
import com.moneyware.digital.enums.DocType;

@Entity
@Table(name="mwfncrp_cust_kyc_docs")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID", updatable = false, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DOC_ID_TYPE")
	private DocIdType docIdType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DOC_TYPE")
	private DocType docType;
	
	@Column(name = "FILE_SIZE")
	private long fileSize;
	
	@Lob
	@Column(name="FILE")
	private byte[] file;
	
	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "UNIQUE_ID", nullable = false, unique = true)
	private UUID uniqueId;
	
	@Column(name = "UPLOADED_AT")
	@CreationTimestamp
	private Date uploadedAt ;
	
	public static final int RADIX = 16;
	
	


	public Document(DocIdType docIdType, DocType docType, long fileSize, byte[] file, String fileName, UUID uniqueId,
			Date uploadedAt) {
		super();
		this.docIdType = docIdType;
		this.docType = docType;
		this.fileSize = fileSize;
		this.file = file;
		this.fileName = fileName;
		this.uniqueId = uniqueId;
		this.uploadedAt = uploadedAt;
	}


	public DocIdType getDocIdType() {
		return docIdType;
	}


	public void setDocIdType(DocIdType docIdType) {
		this.docIdType = docIdType;
	}


	public DocType getDocType() {
		return docType;
	}


	public void setDocType(DocType docType) {
		this.docType = docType;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}


	public byte[] getFile() {
		return file;
	}


	public void setFile(byte[] file) {
		this.file = file;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public UUID getUniqueId() {
		return uniqueId;
	}


	public void setUniqueId(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}


	public Date getUploadedAt() {
		return uploadedAt;
	}


	public void setUploadedAt(Date uploadedAt) {
		this.uploadedAt = uploadedAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
