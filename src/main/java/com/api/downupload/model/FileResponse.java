package com.api.downupload.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javassist.bytecode.ClassFileWriter.FieldWriter;

public class FileResponse {
	
	private String fileName;
    private String fileUrl;
    private String message;
    
    
    
    @JsonIgnoreProperties("fileUrl")
	public FileResponse(String message,String fileName) {
		super();
		this.message=message;
		this.fileName =fileName;
		// TODO Auto-generated constructor stub
	}
	public FileResponse(String fileName, String fileUrl, String message) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.message = message;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
