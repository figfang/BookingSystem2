package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AdminDTO;
import com.model.Admin;

@RestController
public class AdminController {
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> createAdmin(@RequestBody AdminDTO adminDTO) {
	    return ResponseEntity.ok(adminService.createAdmin(adminDTO));
	}

	@PutMapping("/admins/{adminId}")
	public ResponseEntity<Admin> updateAdmin(
	        @PathVariable Integer adminId,
	        @RequestBody AdminDTO adminDTO) {
	    return ResponseEntity.ok(adminService.updateAdmin(adminId, adminDTO));
	}

}
