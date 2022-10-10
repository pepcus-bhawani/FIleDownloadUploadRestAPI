package com.api.downupload.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.downupload.exception.FileNotFoundException;
import com.api.downupload.exception.FileStorageException;
import com.api.downupload.file_read_write.FileReadWrite;
import com.api.downupload.model.FileResponse;
import com.api.downupload.properties.FileUploadProperties;
import org.springframework.http.ResponseEntity;

@Service
public class FileSystemStorageService implements IFileSytemStorage {

	static String fileName;
	
	static String fileDownloadUri;
	@Autowired
	StudentDbService dbService;

	private final Path dirLocation;

	@Autowired
	FileReadWrite fileReadWrite;

	@Autowired
	public FileSystemStorageService(FileUploadProperties fileUploadProperties) {
		this.dirLocation = Paths.get(fileUploadProperties.getLocation()).toAbsolutePath().normalize();
	}

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stub
		try {
			Files.createDirectories(this.dirLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create upload dir!");
		}

	}


	@Override
	public String cheackFileIsValid(MultipartFile file) {

		if (file.isEmpty()) {
			return file.getOriginalFilename();
		}

		return "ok";
	}

	
	
	public ResponseEntity<FileResponse> saveFile1(MultipartFile file) {

		try {

			fileName = file.getOriginalFilename();
			Path dfile = this.dirLocation.resolve(fileName);

			Files.copy(file.getInputStream(), dfile, StandardCopyOption.REPLACE_EXISTING);

			dbService.saveFileDataToDatabase(fileName);
			
			fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/download/")
	                .path(fileName)
	                .toUriString();

			return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(fileName,fileDownloadUri , "File Saved."));
			
		    

		} catch (Exception e) {
			if(e.getClass().toString().equals("class org.springframework.dao.DataIntegrityViolationException"))
			{
				System.out.println("yes ");
				return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(fileName,fileDownloadUri , "Duplicate Entry Not Allowed."));
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(fileName,fileDownloadUri , "Data In File Not Match with Formate."));
		}
	
	}

	@Override
	public Resource loadFile(String fileName) {
		try {

			Path file = this.dirLocation.resolve(fileName).normalize();

		    fileReadWrite.addDataTOFile(file);

			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new FileNotFoundException("Could not find file");
			}
		} catch (MalformedURLException e) {
			throw new FileNotFoundException("Could not download file");
		}

	}

}
