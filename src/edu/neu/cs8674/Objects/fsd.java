package edu.neu.cs8674.Objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class fsd {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity")
	private entity ent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FSDType")
	private fsdtype fsd_t;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="valid_time_id")
	private validtime valid_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="belong_to_FSDContainer")
	private fsdcontainer fsd_container;

	@OneToMany(mappedBy="fsd")
	private List<value> value;
	
	public fsd() {
		super();
		this.id = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public entity getEnt() {
		return ent;
	}

	public void setEnt(entity ent) {
		this.ent = ent;
	}

	public fsdtype getFsd_t() {
		return fsd_t;
	}

	public void setFsd_t(fsdtype fsd_t) {
		this.fsd_t = fsd_t;
	}

	public validtime getValid_time() {
		return valid_time;
	}

	public void setValid_time(validtime valid_time) {
		this.valid_time = valid_time;
	}

	public fsdcontainer getFsd_container() {
		return fsd_container;
	}

	public void setFsd_container(fsdcontainer fsd_container) {
		this.fsd_container = fsd_container;
	}

	public List<value> getValue() {
		return value;
	}

	public void setValue(List<value> value) {
		this.value = value;
	}
	
	
	

}
