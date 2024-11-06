package com.practice.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {

    private CustomLogger() {
    }

    public static Logger getLogger(Class<?> clasz) {
        return LogManager.getLogger(clasz);
    }
}
