package com.api.downupload.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int address_Id;
	
	private String city;
	private String pincode;
	
	@Override
	public String toString() {
		return city + ","+ pincode;
	}
	

	
}
