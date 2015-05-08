package edu.neu.cs8674.Objects;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class value {
	private int value;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="belong_to_FSD")
	private fsd fsd;
	

	public value() {
		super();
	}

	public value(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public fsd getFsd() {
		return fsd;
	}

	public void setFsd(fsd fsd) {
		this.fsd = fsd;
	}
	
	

}
