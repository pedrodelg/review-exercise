package com.belatrix.review.exercise;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.review.console.LoggerConsole;
import com.belatrix.review.db.LoggerDb;
import com.belatrix.review.errors.LevelUtil;
import com.belatrix.review.exception.HandlerException;
import com.belatrix.review.file.LoggerFile;

public class JobLogger {

	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logMessage;
	private static boolean logWarning;
	private static boolean logError;
	private static boolean logToDatabase;
	private static Map dbParams;
	private static Logger logger;

	public JobLogger(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
			boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {

		this.logger = Logger.getLogger("MyLog");
		this.logError = logErrorParam;
		this.logMessage = logMessageParam;
		this.logWarning = logWarningParam;
		this.logToDatabase = logToDatabaseParam;
		this.logToFile = logToFileParam;
		this.logToConsole = logToConsoleParam;
		this.dbParams = dbParamsMap;
	}

	public static void LogMessage(String messageText, boolean message, boolean warning, boolean error)
			throws HandlerException, SecurityException, IOException, SQLException {

		if (messageText == null || messageText.trim().isEmpty()) {
			return;
		}

		if (!logToConsole && !logToFile && !logToDatabase) {
			throw new HandlerException("Invalid configuration");
		}

		if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
			throw new HandlerException("Error or Warning or Message must be specified");
		}

		int t = 0;
		if (message && logMessage) {
			t = LevelUtil.INFO.getValue();
		}

		if (error && logError) {
			t = LevelUtil.ERROR.getValue();
		}

		if (warning && logWarning) {
			t = LevelUtil.WARN.getValue();
		}

		StringBuilder l = new StringBuilder();

		if (error && logError) {
			l.append("error ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
					.append(messageText);
		}

		if (warning && logWarning) {
			l.append("warning ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
					.append(messageText);
		}

		if (message && logMessage) {
			l.append("message ").append(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()))
					.append(messageText);
		}

		if (logToFile) {
			logger.addHandler(LoggerFile.getFileHandler(dbParams));
			logger.log(Level.INFO, messageText);
		}

		if (logToConsole) {
			logger.addHandler(LoggerConsole.getConsoleHandler());
			logger.log(Level.INFO, messageText);
		}

		if (logToDatabase) {
			LoggerDb.executeUpdate(dbParams, "insert into Log_Values('" + message + "', " + String.valueOf(t) + ")");
		}

	}

}
