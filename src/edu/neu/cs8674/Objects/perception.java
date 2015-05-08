package edu.neu.cs8674.Objects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class perception {
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity")
	private entity percp_entity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity")
	private entity percp_activity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guard")
	private entity percp_guard;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="valid_time_id")
	private entity percp_valid_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="featureContainer")
	private entity percp_feature_container;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FOM")
	private entity percp_fom;
	
	

	public perception() {
		super();
		this.id = 0;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public entity getPercp_entity() {
		return percp_entity;
	}



	public void setPercp_entity(entity percp_entity) {
		this.percp_entity = percp_entity;
	}



	public entity getPercp_activity() {
		return percp_activity;
	}



	public void setPercp_activity(entity percp_activity) {
		this.percp_activity = percp_activity;
	}



	public entity getPercp_guard() {
		return percp_guard;
	}



	public void setPercp_guard(entity percp_guard) {
		this.percp_guard = percp_guard;
	}



	public entity getPercp_valid_time() {
		return percp_valid_time;
	}



	public void setPercp_valid_time(entity percp_valid_time) {
		this.percp_valid_time = percp_valid_time;
	}



	public entity getPercp_feature_container() {
		return percp_feature_container;
	}



	public void setPercp_feature_container(entity percp_feature_container) {
		this.percp_feature_container = percp_feature_container;
	}



	public entity getPercp_fom() {
		return percp_fom;
	}



	public void setPercp_fom(entity percp_fom) {
		this.percp_fom = percp_fom;
	}

}
