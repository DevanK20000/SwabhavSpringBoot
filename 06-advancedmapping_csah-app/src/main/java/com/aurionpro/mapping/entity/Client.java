package com.aurionpro.mapping.entity;

import java.sql.Date;
import java.util.List;

import com.aurionpro.mapping.entity.enums.ClientKycStatus;
import com.aurionpro.mapping.entity.enums.ClientStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int clientId;

	@Column
	private String companyName;

	@Column
	private Long registrationNumber;

	@Column
	private String contactPerson;

	@Column
	private String contactEmail;

	@Column
	private Long contactNumber;

	@Column
	private String address;

	@Column
	private ClientStatus status;

	@Column
	private Date creationDate;

	@Column
	private ClientKycStatus clientKycStatus;
	
	@OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JsonManagedReference
	List<Employee> employees;
}