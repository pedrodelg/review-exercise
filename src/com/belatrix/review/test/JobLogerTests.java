package com.belatrix.review.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.belatrix.review.exception.HandlerException;
import com.belatrix.review.exercise.JobLogger;

class JobLogerTests {

	@Test
	void consoleTest() throws SecurityException, HandlerException, IOException, SQLException {
		
		Map<String,String> config = new HashMap<String,String>();
		config.put("ReviewFolser", "logs");
		
		new JobLogger(false, true, false, true, true, true, config);
		JobLogger.LogMessage("test 2", true, false, false);
		
	}
	
	@Test
	void notFoundText() throws Exception {
		assertThrows(HandlerException.class, () -> {
			Map<String,String> config = new HashMap<String,String>();
			config.put("ReviewFolser", "logs");
			
			new JobLogger(true, true, false, true, true, true, config);
			JobLogger.LogMessage("test 2", true, false, false);
	    });
	}

}
