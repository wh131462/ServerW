//package com.wh131462.utils;
//
//import java.time.Instant;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class DateUtil {
//    /**
//     * 获取格式化的时间字符串
//     *
//     * @param time   时间字符串或时间戳，当不指定时间时为当前时间
//     * @param format 时间格式
//     * @return 格式化后的时间字符串
//     */
//    public static String getFormattedTime(String time, String format) {
//        // 使用当前时间戳
//        AtomicLong timestamp = new AtomicLong(System.currentTimeMillis());
//
//        // 如果传入的时间字符串不为空，尝试转化为时间戳
//        Optional<Long> optionalTimestamp = Optional.ofNullable(time)
//                .filter(str -> !str.isEmpty())
//                .map(str -> {
//                    try {
//                        return Long.parseLong(str);
//                    } catch (NumberFormatException e) {
//                        return Instant.parse(str).toEpochMilli();
//                    }
//                });
//
//        // 如果转化成功，使用转化后的时间戳
//        optionalTimestamp.ifPresent(timestamp::set);
//
//        // 根据格式化字符串格式化时间
//        return DateTimeFormatter.ofPattern(format)
//                .withZone(ZoneId.systemDefault())
//                .format(Instant.ofEpochMilli(timestamp.get()));
//    }
//}