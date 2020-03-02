package com.belatrix.review.console;

import java.util.logging.ConsoleHandler;

/**
 * Console logger handler
 * @author emilio.watemberg
 */
public class LoggerConsole {
    public static ConsoleHandler getConsoleHandler(){
        return new ConsoleHandler();
    }
}
