package com.zhang.learn.chapter2023.chapter04.chapter0409;

import java.sql.Date;
import java.time.*;

public class TiemTest {
    public static void main(String[] args) {
//        Instant instant = Instant.now(Clock.system(ZoneId.of("UTC")));
//        System.out.println(instant);
//        System.out.println(instant.getEpochSecond());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(Date.from(Instant.now()));
//        Clock utcClock = Clock.systemUTC();
//        Clock defaultClock = Clock.systemDefaultZone();
//        Clock offsetClock = Clock.offset(Clock.systemUTC(), Duration.ofHours(+8));
//
//        ZoneId denverTimeZone = ZoneId.of("America/Denver");
//        ZoneId newYorkTimeZone = ZoneId.of("America/New_York");
//        ZoneId chicagoTimeZone = ZoneId.of("America/Chicago");
//        ZoneId losAngelesTimeZone = ZoneId.of("America/Los_Angeles");
//        ZoneId shanghai = ZoneId.of("Asia/Shanghai");
//
//        Instant instant = Instant.now(defaultClock);
//        Instant instant2 = Instant.now(utcClock);
//        Instant instant3 = Instant.now(offsetClock);
//
//        System.out.println(instant);
//        System.out.println(instant2);
//        System.out.println(instant3.plus(Duration.ofSeconds(90)));
//        System.out.println(instant3.atZone(newYorkTimeZone));
//        System.out.println(instant3.atZone(chicagoTimeZone));
//        System.out.println(instant3.atZone(denverTimeZone));
//        System.out.println(instant3.atZone(losAngelesTimeZone));
//        System.out.println(instant3.atZone(shanghai));
    }
}
