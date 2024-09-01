package com.aurionpro.bankRest.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.bankRest.entity.ImageStore;
import com.aurionpro.bankRest.repository.ImageStoreRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.aurionpro.bankRest.entity.ImageStore;

@Service
public class ImageStoreService {
	@Autowired
	ImageStoreRepository imageStoreRepo;

	@Autowired
	private Cloudinary cloudinary;

	public ImageStore addImage(String url) {
		ImageStore imageStore = new ImageStore();
		imageStore.setUrl(url);
		return imageStoreRepo.save(imageStore);
	}

	public ImageStore getImage(Integer imageId) {
		return imageStoreRepo.findById(imageId).orElseThrow(() -> new NullPointerException());
	}

	public Map<String, Object> uploadImage(MultipartFile file) throws IOException {
		Map<String, Object> data = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		String url = (String) data.get("secure_url");
		this.addImage(url);
		return data;
	}
}