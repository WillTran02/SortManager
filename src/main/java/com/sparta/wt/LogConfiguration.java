package com.sparta.wt;

import com.sparta.wt.Logging.CustomFormatter;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogConfiguration {

    private static final Logger logger = Logger.getLogger("General Logger");
    public static void setLogConfiguration() {
        try {
            Handler fileHandler = new FileHandler("src/main/java/com/sparta/wt/generalLog.log");
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Logger getLogger() {return logger;}
}