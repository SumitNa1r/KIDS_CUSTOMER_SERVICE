package edu.neu.cs8674.Objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class entity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="ent")
	private List<fsd> fsd;
	
	@OneToMany(mappedBy="entity")
	private List<feature> features;
	
	@OneToMany(mappedBy="fact_entity")
	private List<fact> facts;
	
	@OneToMany(mappedBy="percp_entity")
	private List<perception> perceptions;
	
	@OneToMany(mappedBy="hypt_entity")
	private List<hypothesis> hypothesis;
	
	@OneToMany(mappedBy="dir_entity")
	private List<directive> directives;
	
	public entity() {
		super();
	}
	public entity(int id, String name) {
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
