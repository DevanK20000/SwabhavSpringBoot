package com.aurionpro.bankRest.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.bankRest.entity.ImageStore;
import com.aurionpro.bankRest.service.ImageStoreService;

@RestController
@RequestMapping("/image-app")
public class ImageStoreController {
	@Autowired
	ImageStoreService imageStoreService;

	@PostMapping("/images")
	public ImageStore addImage(@RequestBody String url) {
		return imageStoreService.addImage(url);
	}

	@GetMapping("/images")
	public ImageStore getImage(@RequestParam int imageId) {
		return imageStoreService.getImage(imageId);
	}

	@PostMapping("/images/upload")
	public Map<String, Object> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageStoreService.uploadImage(file);
	}
}