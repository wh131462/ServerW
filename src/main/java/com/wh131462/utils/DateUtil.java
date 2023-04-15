package com.wh131462.utils;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getFormattedTime(String time, String format) {
        if (time == null || time.isEmpty()) {
            time = String.valueOf(Instant.now().toEpochMilli());
        }

        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        long timestamp;
        try {
            timestamp = Long.parseLong(time);
        } catch (NumberFormatException e) {
            timestamp = Instant.parse(time).toEpochMilli();
        }

        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }
}
