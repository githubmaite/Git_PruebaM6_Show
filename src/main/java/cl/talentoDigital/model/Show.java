package cl.talentoDigital.model;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="show_id", nullable = false, unique = true)
	private Long id;
	
	@Size(min = 1, message = "Title must be present")
	private String showTitle;
	
	@Size(min = 1, message = "Network must be present")
	private String showNetwork;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creatorShow;
	
	@OneToMany(mappedBy="show")
	private List<Rating> ratings;
	
	public Show() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getShowNetwork() {
		return showNetwork;
	}

	public void setShowNetwork(String showNetwork) {
		this.showNetwork = showNetwork;
	}

	public User getCreatorShow() {
		return creatorShow;
	}

	public void setCreatorShow(User creatorShow) {
		this.creatorShow = creatorShow;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	

}
