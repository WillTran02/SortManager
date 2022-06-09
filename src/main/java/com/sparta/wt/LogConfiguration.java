package com.sparta.wt;

import com.sparta.wt.Logging.CustomFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogConfiguration {
    public static void setLogConfiguration(Logger logger, String pattern) {
        try {
            Handler fileHandler = new FileHandler(pattern);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setLogConfiguration(Logger logger, String pattern, boolean append) {
        try {
            Handler fileHandler = new FileHandler(pattern, append);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}