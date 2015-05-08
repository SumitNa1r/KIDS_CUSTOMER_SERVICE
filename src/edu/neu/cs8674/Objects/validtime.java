package edu.neu.cs8674.Objects;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class validtime {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date startTime;
	private Date endTime;
	
	@OneToMany(mappedBy="valid_time")
	private List<fsd> fsd;
	
	@OneToMany(mappedBy="valid_tim")
	private List<feature> features;
	
	@OneToMany(mappedBy="fact_valid_time")
	private List<fact> facts;
	
	@OneToMany(mappedBy="percp_valid_time")
	private List<perception> perceptions;
	
	@OneToMany(mappedBy="hypt_valid_time")
	private List<hypothesis> hypothesis;
	
	@OneToMany(mappedBy="dir_valid_time")
	private List<directive> directives;
	
	public validtime() {
		super();
	}
	public validtime(Date startTime, Date endTime) {
		super();
		this.id = 0;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
