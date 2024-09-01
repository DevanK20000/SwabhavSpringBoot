package com.aurionpro.bankRest.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration

public class CloudinaryConfig {


    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "divbhuwio",
            "api_key", "126221465224642",
            "api_secret", "Bw6F2Dw9iel6I_ImKklHzUpZPSc"
        ));
    }
}