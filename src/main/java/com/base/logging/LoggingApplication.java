package com.base.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LoggingApplication {

	final static String className = "com.base.logging.LoggingApplication";
	final static Logger logger = Logger.getLogger(className);

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
		writeLog("tes");
	}

	private static void writeLog(String parameter){
		logger.log(Level.INFO, "test");
	}

}
