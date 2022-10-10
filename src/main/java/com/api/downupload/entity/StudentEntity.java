package com.api.downupload.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
@Entity
@Table(name="student11")
public class StudentEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	private String school ;
	private String sex ;
	private int age ;
	private String address ;
	private String familySize ;
	private String sstatus ;
	private int medu ;
	private int fedu ;
	private String motherJob ;
	private String fatherJob ;
	private String reason ;
	private String guardian ;
	private int travelTime ;
	private int studyTime ;
	private int failures ;
	private String schoolSup ;
	private String famSup ;
	private String paid ;
	private String activities ;
	private String nursery ;
	private String higher ;
	private String internet ;
	private String romantic ;
	private int famrel ;
	private int freeTime ;
	private int goout ;
	private int dalc ;
	private int walc ;
	private int health ;
	private int absences ;
	private String passed ;
	
	
	@Override
	public String toString() {
		return school +","+ sex +","+ age +","+ address+","+ familySize  +","+ sstatus  +","+ medu +","+ fedu +","+  motherJob +","+  fatherJob  +","+ reason +","+  guardian +","+ travelTime   +","+ studyTime  +","+ failures +","+ schoolSup
				 +","+ famSup +","+ paid +","+  activities  +","+ nursery
				+","+ higher +","+ internet +","+ romantic +","+ famrel+","+ freeTime +","+goout + ","+ dalc +","+  walc +","+ health +","+ absences +","+ passed+","+"\n" ;
	}



	
	
	
	

}
