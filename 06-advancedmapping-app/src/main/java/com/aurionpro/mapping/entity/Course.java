package com.aurionpro.mapping.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corses")
@AllArgsConstructor
@NoArgsConstructor
@Data
//@EqualsAndHashCode(exclude = "students")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int courseId;
	@Column
	@NotNull
	@NotBlank
	private String courseName;
	@Column
	@Min(1)
	private int duration;
	@Column
	@Min(1)
	private double fees;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="instructorId")
	@JsonIgnore
	private Instructor instructor;


	@ManyToMany(mappedBy = "courses",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Student> students = new HashSet<>();
}
