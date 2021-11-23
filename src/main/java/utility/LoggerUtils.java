package utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

import projlib.Globals;

public class LoggerUtils 
{
	static Logger log = Logger.getLogger(LoggerUtils.class.getName());
	
	
	public static void loggerSetup()
	{
		DOMConfigurator.configure(Globals.LOG4J_FILE);
	}
	
	
	public static void logInfo(String logMsg)
	{
		log.info(logMsg);
		
	}
	
	public static void logError(String logMsg, Throwable e)
	{
		log.error(logMsg, e);
		
	}
	
}
