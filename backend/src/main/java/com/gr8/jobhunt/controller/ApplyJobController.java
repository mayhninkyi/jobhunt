package com.gr8.jobhunt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gr8.jobhunt.entity.ApplyJob;
import com.gr8.jobhunt.service.ApplyJobService;
import com.gr8.jobhunt.service.StorageService;

@RestController
@RequestMapping("/api")
public class ApplyJobController {
	
	@Autowired
	ApplyJobService service;
	
	@Autowired
	StorageService storageService;

	
	@GetMapping(path = "/applyJobs")
	public List<ApplyJob> getAllApplyJobs() {
		return service.getAll();
	}
	
	@PostMapping(path = "/applyJobs/create")
	public ResponseEntity<?> createApplyJob(@RequestBody ApplyJob applyJob) {
		if (!storageService.check(applyJob.getCvFormPath())) {
			return ResponseEntity.badRequest().body("Cv form is invalid");
		}
		if (!storageService.check(applyJob.getCvVideoPath())) {
			return ResponseEntity.badRequest().body("Cv video is invalid");
		}
		ApplyJob appliedJob= service.create(applyJob);
		if(appliedJob==null) {
			return ResponseEntity.badRequest().body("Error applied job!");
		}
		return ResponseEntity.ok().body(appliedJob);
	}
	
	@PostMapping("/file/create")
	public ResponseEntity<String> createFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType
	) {
		String filePath = storageService.create(file, fileType);
		if (filePath == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok(filePath);
	}

	@PutMapping("/file/update")
	public ResponseEntity<String> updateFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam("fileType") String fileType,
			@RequestParam("filePath") String filePath
	) {
		String newFilePath = storageService.update(file, fileType, filePath);
		if (newFilePath == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok(newFilePath);
	}

}
