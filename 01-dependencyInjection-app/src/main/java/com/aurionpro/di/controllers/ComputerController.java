package com.aurionpro.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.di.entity.Computer;
import com.aurionpro.di.entity.HardDisk;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ComputerController {

	@Autowired
	private Computer computer;
	
	@Autowired
	private HardDisk hardDisk;
	
	
	@GetMapping("/c")
	public Computer getComputer() {
		return computer;
	}
	
	@GetMapping("/hardDisk")
	public HardDisk getHardDisk() {
		return hardDisk;
	}
	
	
}
