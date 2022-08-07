package cl.talentoDigital.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id", nullable = false, unique = true)
	private Long id;

	@Column(name = "role_name")
	private String name;
	
	//INSERT INTO ... para los roles
	
	@ManyToMany(mappedBy = "roles")
	private List<User> Users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return Users;
	}

	public void setUsers(List<User> users) {
		Users = users;
	}
	
	
}
