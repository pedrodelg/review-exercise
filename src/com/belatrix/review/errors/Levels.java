package com.belatrix.review.errors;

/**
 * Define the levels structure
 * @author emilio.watemberg
 */
public abstract class Levels {
	
	protected String name;
	protected int value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}
