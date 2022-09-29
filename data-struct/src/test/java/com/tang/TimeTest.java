package com.tang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * TODO: 该类作用
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/9/27 15:08
 */
public class TimeTest {

    Logger log = LoggerFactory.getLogger(TimeTest.class);

    @Test
    public void timeTest() {
        // 得到当前时间一周后的时间
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime week = now.plus(1, ChronoUnit.WEEKS);
        System.out.println("next week: " + week);

        // 得到前一年
        LocalDateTime previousYear = now.minus(1, ChronoUnit.YEARS);
        System.out.println("previous year: " + previousYear);

        // Clock获取时间戳
        // 
        Clock clock = Clock.systemUTC();
        System.out.println("Clock: " + clock.toString());

        // 时区
        ZoneId america = ZoneId.of("America/New_York");
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(now, america);
        System.out.println("现在的日期和时间在特定的时区：" + dateAndTimeInNewYork);


    }

    // YearMonth用法
    @Test
    public void checkCardExpiry() {
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Today in month of year %s: %s %n", currentYearMonth, currentYearMonth.lengthOfMonth());
        //Today in month of year 2022-09: 30

        YearMonth creditCardExpiry = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
        //Your credit card expires on 2028-02 
    }

    // 检查闰年
    @Test
    public void isLeapYear() {
        LocalDate today = LocalDate.now();
        if (today.isLeapYear()) {
            log.info("This year is Leap year");
        } else {
            log.info("This year is not Leap year");
        }
    }

    // 计算两个日期之间相差的年月日
    @Test
    public void calcDateDays() {
        LocalDate today = LocalDate.now();
        LocalDate next = LocalDate.of(2023, Month.DECEMBER, 14);
        Period period = Period.between(today, next);
        log.info("now: {}  next:　{}", today, next);
        log.info("Today between Next: {} year {} month and {} days", period.getYears(), period.getMonths(), period.getDays());
        // Today between Next: 1 year 2 month and 16 days
    }
    
    // Instant
    @Test
    public void getTimeStamp() {
        Instant instant = Instant.now();
        long epochMilli = instant.toEpochMilli();
        log.info("instant {}", instant);
        log.info("epochMilli {}", epochMilli);
        log.info("nano {}",  instant.getNano());
    }
    
    // 格式化时间
    @Test
    public void formatDate() {
        String stringDate = "20220928";
        LocalDate localDate = LocalDate.parse(stringDate, DateTimeFormatter.BASIC_ISO_DATE);
        log.info("Date generated from string {} is {}", stringDate, localDate);
    }

}
