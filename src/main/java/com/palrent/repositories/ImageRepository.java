package com.palrent.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palrent.models.Image;
@Repository
public interface ImageRepository extends CrudRepository<Image, Long>{
	List<Image> findAll();

}
