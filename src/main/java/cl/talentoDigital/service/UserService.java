package cl.talentoDigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.talentoDigital.dao.RoleRepository;
import cl.talentoDigital.dao.ShowRepository;
import cl.talentoDigital.dao.UserRepository;
import cl.talentoDigital.model.User;

import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEnconder;
	
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEnconder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	
	public void saveWithAdminrRole(User user) {
		user.setPassword(bCryptPasswordEnconder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User findUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public void createUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	
	
}
