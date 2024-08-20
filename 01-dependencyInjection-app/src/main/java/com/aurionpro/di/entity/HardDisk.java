package com.aurionpro.di.entity;

import org.springframework.beans.factory.annotation.Value;

public class HardDisk {
	@Value("128")
	private Integer capacity;

	public HardDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  HardDisk(Integer capacity) {
		super();
		this.capacity=capacity;
	}
	
	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}	
}
