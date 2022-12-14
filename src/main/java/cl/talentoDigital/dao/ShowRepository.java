package cl.talentoDigital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.talentoDigital.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
	List<Show> findAll();
	
	

}
