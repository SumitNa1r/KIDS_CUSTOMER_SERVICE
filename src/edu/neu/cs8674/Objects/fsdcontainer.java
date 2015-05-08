package edu.neu.cs8674.Objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class fsdcontainer {

	@Id
	private int id;
	
	@OneToMany(mappedBy="fsd_container")
	private List<fsd> fsd;
	
	@OneToMany(mappedBy="fact_fsd_container")
	private List<fact> facts;

	public fsdcontainer() {
		super();
	}

	public fsdcontainer(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<fsd> getFsd() {
		return fsd;
	}

	public void setFsd(List<fsd> fsd) {
		this.fsd = fsd;
	}

	public List<fact> getFacts() {
		return facts;
	}

	public void setFacts(List<fact> facts) {
		this.facts = facts;
	}
	
}
