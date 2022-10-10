package com.api.downupload.service;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.api.downupload.entity.Address;
import com.api.downupload.entity.Parents;
import com.api.downupload.entity.Student;
import com.api.downupload.entity.StudentEntity;
import com.api.downupload.file_read_write.FileReadWrite;
import com.api.downupload.repo.StudentRepo;
import com.api.downupload.repo.StudentRepository;
@Component
public class StudentDbService {

	@Value("${file.upload.location}")
	private String filePath;
	@Autowired
	FileReadWrite fileReadWrite;
	@Autowired
	StudentRepository repo;
    public boolean saveFileDataToDatabase(String fileName)
    {
    	
    	
    	System.out.println("saving data to db");
    	
    	List list = fileReadWrite.fileList(fileName);
    	
    	List<Student> studentList = new ArrayList<>();
    	
    	for (int i=0; i<list.size();i++)
    	{
    		List l =(List) list.get(i);
    		
    		
    		Student student=new Student();
    		
    		student.setRollNumber(Integer.parseInt(String.valueOf(l.get(0))));
    		student.setName(String.valueOf(l.get(1)));
            student.setAge(Integer.parseInt(String.valueOf(l.get(2))));
            student.setEmail(String.valueOf(l.get(3)));
            
            //studentList.add(student);
            
            Parents parents = new Parents();
            
            parents.setMotherNmae(String.valueOf(l.get(4)));
            parents.setFatherName(String.valueOf(l.get(5)));
            parents.setEmail(String.valueOf(l.get(6)));
            parents.setMobileNumber(String.valueOf(l.get(7)));
            
            Address address = new Address();
            
            address.setCity(String.valueOf(l.get(8)));
            
            address.setPincode(String.valueOf(l.get(9)));
            
            student.setAddress(address);
            
            
            student.setParents(parents);
            
            
            studentList.add(student);
    		
    		
    	}
    	
    	repo.saveAll(studentList);
    
    	 return true;
    }
    
	
    
	
	
	
	
	
}
