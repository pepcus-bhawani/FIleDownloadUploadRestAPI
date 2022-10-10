package com.api.downupload.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.api.downupload.model.FileResponse;

public interface IFileSytemStorage {
	
	void init();
	Resource loadFile(String fileName);
	public ResponseEntity<FileResponse> saveFile1(MultipartFile file);
    String cheackFileIsValid(MultipartFile file);

}
