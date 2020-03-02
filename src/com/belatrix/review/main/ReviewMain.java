package com.belatrix.review.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.belatrix.review.exception.HandlerException;
import com.belatrix.review.exercise.JobLogger;

public class ReviewMain {

	public static void main(String[] args) throws SecurityException, HandlerException, IOException, SQLException {
		
		Map<String,String> config = new HashMap<String,String>();
		config.put("ReviewFolser", "logs");
		
		JobLogger jobLogger = new JobLogger(false, true, false, true, true, true, config);
		JobLogger.LogMessage("test 2", true, false, false);

	}

}
