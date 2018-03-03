package act.nsfc.kfkDataPorterMC.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {
	static Logger logger = LogManager.getLogger("mcLogger");
	public static void main(String[] args) {
		logger.error("this is an error!");
		logger.log(Level.INFO, "this is a log of level.INFO");
		logger.trace("this is a trace");
	}
	
}
