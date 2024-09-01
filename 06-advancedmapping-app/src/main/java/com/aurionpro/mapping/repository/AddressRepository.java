package com.aurionpro.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.mapping.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
