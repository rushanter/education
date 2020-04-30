package com.education.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wangtonghe
 * @since 2018/3/21 16:14
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static final String ISO_LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.ISO_LOCAL_DATE_FORMAT);

    private static final int MAX_UNIT = 10;


    /**
     * 计算两日期差值，java8方式
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 日期差值
     */
    public static int diffDays(Date start, Date end) {
        LocalDate startLocalDate = LocalDateTime.ofInstant(start.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = LocalDateTime.ofInstant(end.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return (int) ChronoUnit.DAYS.between(startLocalDate, endLocalDate);

    }

    /**
     * 添加日期
     *
     * @param date 日期
     * @param days 天数
     * @return 新日期
     */
    public static Date addDays(Date date, int days) {
        try {
            date = simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e) {
            logger.error("日期转化异常", e);
        }
        return new Date(date.getTime() + days * 24 * 60 * 60 * 1000L);
    }


    public static String getCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String curTime = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        String hourStr = String.valueOf(hour), minuteStr = String.valueOf(minute);
        if (hour < MAX_UNIT) {
            hourStr = "0" + hour;
        }
        if (minute < MAX_UNIT) {
            minuteStr = "0" + minute;
        }
        curTime += " " + hourStr + ":" + minuteStr;
        return curTime;
    }

    public static String getDateTime() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String date = df.format(new Date());
        Date dt=df.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MINUTE,-1);
        return df.format(rightNow.getTime());
    }

    /**
     * 获取所传时间的0时时间戳
     *
     * @return time
     */
    public static long getTodayZeroTime() {
        //当天零点
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        return today.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取所传时间的终点时时间戳
     *
     * @return time
     */
    public static long getTodayEndTime() {
        //当天零点
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return today.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

}
