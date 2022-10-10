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
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_Id;
	@Column(unique = true)
	private Integer rollNumber;
	private String name;
    private Integer age;
    @Column(unique = true)
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parents_Id", referencedColumnName = "parents_Id")
    Parents parents;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_Id", referencedColumnName = "address_Id")
    Address address;
    
	@Override
	public String toString() {
		return rollNumber + "," + name + "," + age + "," + email+","+parents+","+address+"\n";
	}
    
    
    
 
   
    
	

}
