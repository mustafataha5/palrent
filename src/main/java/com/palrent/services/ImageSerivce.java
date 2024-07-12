package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palrent.models.Image;
import com.palrent.repositories.ImageRepository;

@Service
public class ImageSerivce {
	@Autowired
	ImageRepository imageRepository;

	public List<Image> allImage() {
		return imageRepository.findAll();
	}

	public Image createImage(Image i) {
		return imageRepository.save(i);
	}

	public Image findImage(Long id) {
		Optional<Image> op = imageRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public Image update(Image i) {
		Optional<Image> op = imageRepository.findById(i.getId());
		if (op.isPresent()) {
			return imageRepository.save(i);
		}
		return null;
	}
}
