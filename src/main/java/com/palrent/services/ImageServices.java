package com.palrent.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palrent.models.Image;
import com.palrent.models.Offer;
import com.palrent.repositories.ImageRepository;

@Service
public class ImageServices {
	@Autowired
	ImageRepository imagerepository;
	
	public List<Image> allImage(){
		return imagerepository.findAll();
	}
	
	public Image createImage(Image i) {
		return imagerepository.save(i);
	}
	public Image findImage(Long id) {
		Optional<Image> optional = imagerepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null ;
	}
	
	public Image updateImage(Image image) {
		Optional<Image> optional = imagerepository.findById(image.getId());
		if(optional.isPresent()) {
			return imagerepository.save(image);
		}
		return null ;
	}
	public void deleteImage(Long id) {
		imagerepository.deleteById(id);
	}
	
}
