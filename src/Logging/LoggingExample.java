package Logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {

    private static final Logger logger = Logger.getLogger("LoggingExample");

    public static void main(String[] args) throws InterruptedException {

        logger.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        logger.severe("Fehler aufgetreten!");
        logger.warning("Achtung!");
        logger.info("App gestartet.");
        logger.fine("Benutzer X angemeldet.");
        logger.finer("API-Request erfolgreich.");
        logger.finest("Debug: x=42 in processData().");

    }
}

