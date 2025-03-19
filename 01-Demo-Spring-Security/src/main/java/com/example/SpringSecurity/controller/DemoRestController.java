package com.example.SpringSecurity.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("users")
public class DemoRestController {

	@GetMapping()
	public String getMethod() {
		return "This method was return get method";
	}
	
	@PostMapping()
	public String postMethod() {
		return "This method was return post method";
	}
	
	@PutMapping()
	public String putMethod() {
		return "This method was return put method";
	}
	
	@DeleteMapping()
	public String deleteMethod() {
		return "This method was return delete method";
	}
}
