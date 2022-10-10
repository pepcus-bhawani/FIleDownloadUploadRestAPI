package com.api.downupload.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Parents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parents_Id;
	
	private String motherNmae;
	private String fatherName;
	@Column(unique = true)
	private String email;
	
	private String mobileNumber;
	
	    
		@Override
		public String toString() {
			return motherNmae + "," + fatherName + "," + email+ "," + mobileNumber  ;
		}
	    
	
	
	
	

}
