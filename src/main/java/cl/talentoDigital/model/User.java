package cl.talentoDigital.model;

import java.util.List;

import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id", nullable = false, unique = true)
	private Long id;
	
	@Size(min = 3, message = "Username must be present")
	private String username;
	
	@Size(min = 5, message = "Email must be greater than 5")
	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@Size(min = 5, message = "Password must be greater than 5 characters")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	//1:N Shows
	
	@OneToMany(mappedBy = "creatorShow", fetch = FetchType.LAZY)
	private List<Show> userShows;
	
	
	//1:N Rating
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Rating> ratings;
	
	
	
	//N:N Roles
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}



	public List<Show> getUserShows() {
		return userShows;
	}



	public void setUserShows(List<Show> userShows) {
		this.userShows = userShows;
	}



	public List<Rating> getRatings() {
		return ratings;
	}



	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	
}
