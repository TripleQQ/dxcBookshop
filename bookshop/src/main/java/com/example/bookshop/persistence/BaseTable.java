package com.example.bookshop.persistence;
import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
public class BaseTable implements Serializable{
	
	@Column(name="CREATEDBY")
	private String createdBy;
	
	@Column(name="CREATEDON")
	private Timestamp createdOn;
	
	@Column(name="UPDATEDBY")
	private String updatedBy;
	
	@Column(name="UPDATEDON")
	private Timestamp updatedOn;
	

}
