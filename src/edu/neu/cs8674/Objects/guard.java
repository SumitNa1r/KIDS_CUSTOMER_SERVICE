package edu.neu.cs8674.Objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class guard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="fact_guard")
	private List<fact> facts;
	
	@OneToMany(mappedBy="percp_guard")
	private List<perception> perceptions;
	
	@OneToMany(mappedBy="hypt_guard")
	private List<hypothesis> hypothesis;
	
	@OneToMany(mappedBy="dir_guard")
	private List<directive> directives;
	
	public guard() {
		super();
	}
	public guard(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

