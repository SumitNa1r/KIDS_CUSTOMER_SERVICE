package edu.neu.cs8674.Objects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class hypothesis {

	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity")
	private entity hypt_entity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity")
	private entity hypt_activity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guard")
	private entity hypt_guard;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="valid_time_id")
	private entity hypt_valid_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="featureContainer")
	private entity hypt_feature_container;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FOM")
	private entity hypt_fom;

	public hypothesis() {
		super();
		this.id = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public entity getHypt_entity() {
		return hypt_entity;
	}

	public void setHypt_entity(entity hypt_entity) {
		this.hypt_entity = hypt_entity;
	}

	public entity getHypt_activity() {
		return hypt_activity;
	}

	public void setHypt_activity(entity hypt_activity) {
		this.hypt_activity = hypt_activity;
	}

	public entity getHypt_guard() {
		return hypt_guard;
	}

	public void setHypt_guard(entity hypt_guard) {
		this.hypt_guard = hypt_guard;
	}

	public entity getHypt_valid_time() {
		return hypt_valid_time;
	}

	public void setHypt_valid_time(entity hypt_valid_time) {
		this.hypt_valid_time = hypt_valid_time;
	}

	public entity getHypt_feature_container() {
		return hypt_feature_container;
	}

	public void setHypt_feature_container(entity hypt_feature_container) {
		this.hypt_feature_container = hypt_feature_container;
	}

	public entity getHypt_fom() {
		return hypt_fom;
	}

	public void setHypt_fom(entity hypt_fom) {
		this.hypt_fom = hypt_fom;
	};
	
}
