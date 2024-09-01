package com.aurionpro.bankRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.bankRest.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

}
