package cl.talentoDigital.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.talentoDigital.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	List<User> findAll();
		
	User findByUsername(String username);
	
	//User findUserByEmail(String email);
	@Select("select * from users where email = ?1")
	User findUserByEmail(String email);
	

}
