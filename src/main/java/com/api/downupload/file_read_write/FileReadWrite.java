package com.api.downupload.file_read_write;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.validator.internal.metadata.location.FieldConstraintLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.api.downupload.entity.Parents;
import com.api.downupload.entity.Student;
import com.api.downupload.entity.StudentEntity;
import com.api.downupload.repo.StudentRepo;
import com.api.downupload.repo.StudentRepository;

import javassist.bytecode.ClassFileWriter.FieldWriter;


/**
 * 
 * @author Pepcus.Bhawani.Singh
 * 
 * class to read data from file 
 *
 */
@Component
public class FileReadWrite {

	@Value("${file.upload.location}")
	String filePath;
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	StudentRepository studentRepo1;
	
	// This method reads data from file and convert data into nested list and return the list.
	public List fileList(String fileName)
	{
		
		String filePath1=filePath+"/"+fileName;
		List l=new ArrayList();
		try {
		      File myObj = new File(filePath1);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] dataArr=data.split("\\|");
		        List<String> list=Arrays.asList(dataArr);
		        l.add(list);
		        
		      }

		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		return l;
	}
	
	// method reads data from database and save data to text file
	public boolean addDataTOFile(Path filePathTOWriteFile)
	{
		int flag=0;
		
		
	    try {
	    	String fileLocation=filePathTOWriteFile.toString();
	        File myObj = new File(fileLocation);
	        if (myObj.createNewFile()) {
	          System.out.println("File created: " + myObj.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	        
	        FileWriter myWriter = new FileWriter(fileLocation);
	        List<Student> list = (List<Student>) studentRepo1.findAll();  
	        pipToComma(list,myWriter);
	        myWriter.close();
	        flag =1;
	        
	     } 
	      catch(IOException e)
	      { 
	    	  e.printStackTrace();
	      }
	     
	    
	   if(flag==1)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }

	}
	
	public static  void pipToComma(List list,FileWriter myWriter) throws IOException
	{
		int i;
		   for ( i=0;i<list.size();i++)
	        {	
			  
			  String s=list.get(i).toString();
			   myWriter.write(s);
	        }
		   
		   myWriter.close();
		    
	}


}
