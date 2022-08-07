package cl.talentoDigital.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.talentoDigital.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	List<Role> findAll();
	
	List<Role> findByName(String name);
}
