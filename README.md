# example.log4j
Contains an easy example for configuration of a log4j2 logger via XML. 

## decoupling from concrete logging library
Additionally it shows a way how the concrete logging librabry can be decoupled from the rest of the classes. Therefore a proper interface is introduced 
offering required logging methods (debug, warn, info, fatal). 

```java
public interface ILoggerWrapper {
    void debug(String message);
    void fatal(String message);
    void error(String message);
    void warn(String message);
}
```

The factory LoggerFactory creates a logger implementing ILoggerWrapper.

```java
private static final ILoggerWrapper logger = LoggerFactory.getLogger();
```

The concrete ILoggerWrapper implementation Log4j2Wrapper wraps around log4j2 Logger. It supports the states InitialzedState and UninitializedState representing the logger
in the state before and after initialization.

## configuration
The logger is configured by the configuration file log4j2.xml placed under ../src/main/resources/log4j2.xml.
It specifes the global status DEBUG and create a File and Console Appender.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="DEBUG">
    <Appenders>
        <Console name="ConsoleAppender" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
        </Console>
        <File name="FileAppender" fileName="application-${date:yyyyMMdd}.log" immediateFlush="false" append="true">
            <PatternLayout pattern="%d{yyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <AppenderRef ref="ConsoleAppender" />
            <AppenderRef ref="FileAppender"/>
        </Root>
    </Loggers>
</Configuration>
```

For further configuration go through https://logging.apache.org/log4j/2.x/manual/configuration.html.
