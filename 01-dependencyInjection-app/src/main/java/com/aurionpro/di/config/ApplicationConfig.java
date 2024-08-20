package com.aurionpro.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aurionpro.di.entity.Computer;
import com.aurionpro.di.entity.HardDisk;

@Configuration
public class ApplicationConfig {

    @Bean
    Computer getComputer() {
		return new Computer();				
	}
    
    @Bean
    HardDisk getHardDisk() {
    	return new HardDisk();
    }
}
