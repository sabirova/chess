package com.chessgame.server;


import com.chessgame.logger.LoggerManager;

public class ServerLogger {

    private ServerLogger() {
    }

    public static void info(Object message) {
        LoggerManager.TRACE_FILE_LOGGER.info(message);
        LoggerManager.TRACE_CONSOLE_LOGGER.info(message);
    }

    public static void error(Object message) {
        LoggerManager.ERROR_FILE_LOGGER.error(message);
    }


}
