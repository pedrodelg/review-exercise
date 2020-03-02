package com.belatrix.review.errors;

/**
 * Define levels WARN > ERROR > INFO
 * 
 * @author emilio.watemberg
 */
public class LevelUtil extends Levels {

	public LevelUtil(String name, int value) {
		this.setName(name);
		this.setValue(value);
	}

	public static final LevelUtil INFO = new LevelUtil("INFO", 1);

	public static final LevelUtil ERROR = new LevelUtil("ERROR", 2);

	public static final LevelUtil WARN = new LevelUtil("WARN", 3);

}
