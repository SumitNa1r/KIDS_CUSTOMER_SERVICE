package edu.neu.cs8674.Objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class featurecontainer {
	@Id
	private int id;
	
	@OneToMany(mappedBy="feature_c")
	private List<feature> features;
	
	@OneToMany(mappedBy="fact_feature_container")
	private List<fact> facts;
	
	@OneToMany(mappedBy="percp_feature_container")
	private List<perception> perceptions;
	
	@OneToMany(mappedBy="hypt_feature_container")
	private List<hypothesis> hypothesis;
	
	@OneToMany(mappedBy="dir_feature_container")
	private List<directive> directives;

	public featurecontainer() {
		super();
	}

	public featurecontainer(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
