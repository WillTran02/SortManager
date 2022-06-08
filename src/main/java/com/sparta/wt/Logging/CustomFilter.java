package com.sparta.wt.Logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        if (record.getMessage().contains("hello")) {
            return true;
        } else {
            return false;
        }
    }
}
