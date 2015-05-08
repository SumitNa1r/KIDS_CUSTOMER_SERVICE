package edu.neu.cs8674.Objects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class feature {

	private int id;
	private int value;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity")
	private entity entity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="featureType")
	private featuretype feature_t;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="belong_to_featureContainer")
	private featuretype feature_c;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="valid_time_id")
	private validtime valid_tim;
	
	public feature() {
		super();
	}
	public feature(int id, int value) {
		super();
		this.id = id;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public entity getEntity() {
		return entity;
	}
	public void setEntity(entity entity) {
		this.entity = entity;
	}
	public featuretype getFeature_t() {
		return feature_t;
	}
	public void setFeature_t(featuretype feature_t) {
		this.feature_t = feature_t;
	}
	public featuretype getFeature_c() {
		return feature_c;
	}
	public void setFeature_c(featuretype feature_c) {
		this.feature_c = feature_c;
	}
	public validtime getValid_tim() {
		return valid_tim;
	}
	public void setValid_tim(validtime valid_tim) {
		this.valid_tim = valid_tim;
	}
	
}
