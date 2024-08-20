package com.aurionpro.first.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class firstRestController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello welcome to spring boot";
	}
	
	@GetMapping("bye")
	public String sayBye() {
		return "Bye";
	}
	

}
