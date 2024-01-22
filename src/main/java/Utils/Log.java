package Utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log {
	
	public static Logger log = LogManager.getLogger(Log.class.getName());
	
	public static void StartTestCase(String TestCaseName) {
		
		log.info("====================================" + TestCaseName + "==========================================");
	}
	
	public static void EndTestCase(String TestCaseName) {
		
	    log.info("====================================" + TestCaseName + "==========================================");
	}
	
	public static void Info(String message) {
		
		log.info(message);
	}
	
	public static void Warn(String message) {
		
		log.warn(message);
	}
	
	public static void Error(String message) {
		
		log.error(message);
	}

}
