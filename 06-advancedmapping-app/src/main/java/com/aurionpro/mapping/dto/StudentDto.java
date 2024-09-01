package com.aurionpro.mapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentDto {
	private int rollno;
	private String name;
	private String email;
	private int age;
}
