package com.zhang.learn.chapter2023.chapter04.chapter0410;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TimeUtil {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);
        LocalDate localDate = now.withDayOfMonth(1);
        System.out.println(localDate);
        LocalDate withMonth = now.withMonth(6);
        System.out.println(withMonth);
        LocalDate firstDayOfNextMonth = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(firstDayOfNextMonth);
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
        LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(nextSunday);

    }
}
