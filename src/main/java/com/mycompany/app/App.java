package com.mycompany.app;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger logger = LogManager.getLogger("WARN");
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        logger.error("Hello, World!");
        
    }
}
