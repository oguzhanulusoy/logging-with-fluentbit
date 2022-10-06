package com.base.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.base.logging.Log;

@SpringBootApplication
public class LoggingApplication {

	final static String className = "com.base.logging.LoggingApplication";
	static Log log = null;

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
		log = new Log();
		writeLog("KOCAMAN HARFLERLE LOG BASIYORUM TAM BURAYA!!!");
	}

	private static void writeLog(String parameter){
		log.info(parameter);
		System.out.println("I wrote a log. Yey!");
	}

}
