package edu.neu.cs8674.Objects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class directive {

	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity")
	private entity dir_entity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity")
	private entity dir_activity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guard")
	private entity dir_guard;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="valid_time_id")
	private entity dir_valid_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="featureContainer")
	private entity dir_feature_container;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FOM")
	private entity dir_fom;

	public directive() {
		super();
		this.id = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public entity getDir_entity() {
		return dir_entity;
	}

	public void setDir_entity(entity dir_entity) {
		this.dir_entity = dir_entity;
	}

	public entity getDir_activity() {
		return dir_activity;
	}

	public void setDir_activity(entity dir_activity) {
		this.dir_activity = dir_activity;
	}

	public entity getDir_guard() {
		return dir_guard;
	}

	public void setDir_guard(entity dir_guard) {
		this.dir_guard = dir_guard;
	}

	public entity getDir_valid_time() {
		return dir_valid_time;
	}

	public void setDir_valid_time(entity dir_valid_time) {
		this.dir_valid_time = dir_valid_time;
	}

	public entity getDir_feature_container() {
		return dir_feature_container;
	}

	public void setDir_feature_container(entity dir_feature_container) {
		this.dir_feature_container = dir_feature_container;
	}

	public entity getDir_fom() {
		return dir_fom;
	}

	public void setDir_fom(entity dir_fom) {
		this.dir_fom = dir_fom;
	}
	
}
