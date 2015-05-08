package edu.neu.cs8674.Objects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class fact {

	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity")
	private entity fact_entity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity")
	private entity fact_activity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="guard")
	private entity fact_guard;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="valid_time_id")
	private entity fact_valid_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fsdContainer")
	private entity fact_fsd_container;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="featureConatiner")
	private entity fact_feature_container;
	
	public fact() {
		super();
		this.id = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public entity getFact_entity() {
		return fact_entity;
	}

	public void setFact_entity(entity fact_entity) {
		this.fact_entity = fact_entity;
	}

	public entity getFact_activity() {
		return fact_activity;
	}

	public void setFact_activity(entity fact_activity) {
		this.fact_activity = fact_activity;
	}

	public entity getFact_guard() {
		return fact_guard;
	}

	public void setFact_guard(entity fact_guard) {
		this.fact_guard = fact_guard;
	}

	public entity getFact_valid_time() {
		return fact_valid_time;
	}

	public void setFact_valid_time(entity fact_valid_time) {
		this.fact_valid_time = fact_valid_time;
	}

	public entity getFact_fsd_container() {
		return fact_fsd_container;
	}

	public void setFact_fsd_container(entity fact_fsd_container) {
		this.fact_fsd_container = fact_fsd_container;
	}

	public entity getFact_feature_container() {
		return fact_feature_container;
	}

	public void setFact_feature_container(entity fact_feature_container) {
		this.fact_feature_container = fact_feature_container;
	}
	
}
