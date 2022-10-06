package com.base.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

@SpringBootApplication
public class LoggingApplication {

	private static final Logger logger = Logger.getLogger(String.valueOf(LoggingApplication.class));

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
		JSONObject obj = new JSONObject();
		obj.put("message","BURAYA BİR ADET LOG YAZDIM");
		logger.info(obj);
	}
}