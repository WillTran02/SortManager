package com.sparta.wt.Logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return getDateFormat()
                + " " + record.getLevel()
                + " " + record.getMessage() + "\n";
    }

    private String getDateFormat() {
        return LocalDateTime
                .now()
                .format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
