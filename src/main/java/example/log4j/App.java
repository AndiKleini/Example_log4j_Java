package example.log4j;

import example.log4j.logger.ILoggerWrapper;
import example.log4j.logger.LoggerFactory;

public class App
{
    // get the logger from a factory so that the concrete implementation is hidden behind some interface
    private static final ILoggerWrapper logger = LoggerFactory.getLogger();

    public static void main( String[] args ) {
        // use different methods to write messages with desired degree of severity
        logger.debug("This is a debug message.");
        logger.fatal("This is a fatal message.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");
    }
}

