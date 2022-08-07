package cl.talentoDigital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.talentoDigital.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	List<Rating> findAll();
	
}
