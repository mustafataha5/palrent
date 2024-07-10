package com.palrent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.palrent.models.Image;




public interface ImageRepository extends CrudRepository <Image, Long> {
	List<Image> findAll();
	

}
