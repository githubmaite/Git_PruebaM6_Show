package cl.talentoDigital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.talentoDigital.dao.ShowRepository;
import cl.talentoDigital.model.Show;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;
	
	//FIND ONE
	public Show findById(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		}else {
			return null;
		}
	}
	
	//FIND ALL
	
	public List<Show> findAllShows(){
		return showRepository.findAll();
	}
	
	//CREATE
	public void saveShow(Show show) {
		showRepository.save(show);
	}
	
	//UPDATE
	public void updateShow(Show show) {
		showRepository.save(show);
	}
	
	//DELETE
	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
	
	
}
