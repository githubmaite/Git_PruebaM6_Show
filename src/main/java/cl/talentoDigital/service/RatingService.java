package cl.talentoDigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.dao.RatingRepository;
import cl.talentoDigital.model.Rating;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Rating> findAllRatings(){
		return ratingRepository.findAll();
	}
	
	public Rating findRatingById(Long id) {
		return ratingRepository.findById(id).orElse(null);
	}
	
	public void addRating(Rating rating) {
		rating.setId(null);
		
		List<Rating> Ratings =  ratingRepository.findAll();
		
		System.out.println(rating.getUser().getId());
		System.out.println(rating.getShow().getId());
		
		  for(Rating element : Ratings) {
			  
			  if(element.getUser().getId() == rating.getUser().getId() && element.getShow().getId() == rating.getShow().getId()) {
				  rating.setId(element.getId());
			  }
		  }
		 

		ratingRepository.save(rating);
	}
	
}
