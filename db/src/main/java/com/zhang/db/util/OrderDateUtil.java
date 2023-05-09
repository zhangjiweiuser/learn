package com.zhang.db.util;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-05-09 9:46
 */
public class OrderDateUtil {
    private static final LocalTime time = LocalTime.of(15, 0, 0);

    public static void main(String[] args) {
        System.out.println("9-" + calculateDate(new Date(123, Calendar.MAY, 9, 12, 12, 0)));
        System.out.println("10-" + calculateDate(new Date(123, Calendar.MAY, 10, 12, 12, 0)));
        System.out.println("11-" + calculateDate(new Date(123, Calendar.MAY, 11, 12, 12, 0)));
        System.out.println("12-" + calculateDate(new Date(123, Calendar.MAY, 12, 12, 12, 0)));
        System.out.println("12-" + calculateDate(new Date(123, Calendar.MAY, 12, 17, 12, 0)));
        System.out.println("13-" + calculateDate(new Date(123, Calendar.MAY, 13, 12, 12, 0)));
        System.out.println("14-" + calculateDate(new Date(123, Calendar.MAY, 14, 12, 12, 0)));
        System.out.println("15-" + calculateDate(new Date(123, Calendar.MAY, 15, 12, 12, 0)));
        System.out.println("16-" + calculateDate(new Date(123, Calendar.MAY, 16, 12, 12, 0)));
    }

    private static LocalDate calculateDate(Date orderCreateTime) {
        LocalDateTime localDateTime = Instant.ofEpochMilli(orderCreateTime.getTime()).atOffset(ZoneOffset.ofHours(8)).toLocalDateTime();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDate date = localTime.isAfter(time)
                ? localDateTime.plusDays(2L).toLocalDate()
                : localDateTime.plusDays(1L).toLocalDate();
        return wrapDate(date);
    }

    private static LocalDate wrapDate(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SUNDAY ? localDate.plusDays(1L) : localDate;
    }
}
