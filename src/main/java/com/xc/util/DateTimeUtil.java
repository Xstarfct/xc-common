package com.xc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.xc.check.ParamCheck;

/**
 * 有关时间相关的工具类
 * 
 * @author xstarfct
 * @version 2019-02-18 14:25
 */
public class DateTimeUtil {
    /**
     * 默认格式化
     */
    public final static String DEFAULT_FORMATOR = "yyyy-MM-dd HH:mm:ss";
    /**
     * 到天的格式化
     */
    public final static String DAY_FORMATOR     = "yyyy-MM-dd";
    /**
     * 到月份的格式化
     */
    public static final String MONTH_FORMATOR   = "yyyy-MM";
    /**
     * 0时间，开始
     */
    public final static String ZERO_CLOCK       = " 00:00:00";

    public final static long   MINITE_UNIT      = 1000 * 60L;

    public final static long   YEAR             = GregorianCalendar.YEAR;

    public final static long   MONTH            = GregorianCalendar.MONTH;

    public final static long   DATE             = GregorianCalendar.DATE;

    public static Date getMonthStartTime(Date date, int month) {
        Date time = DateUtils.addMonths(date, month);
        Date firstDayOfMonth = getFirstDayOfMonth(time);
        String format = DateFormatUtils.format(firstDayOfMonth, DateTimeUtil.DAY_FORMATOR);
        try {
            return DateUtils.parseDate(format, DateTimeUtil.DAY_FORMATOR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.set(Calendar.DAY_OF_MONTH, 1);
        return cd.getTime();
    }

    /**
     * 获取某时间对应的当天起始时间
     *
     * @param date
     * @return
     */
    public static Date getDateStart(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.set(Calendar.HOUR_OF_DAY, 0);
        cd.set(Calendar.MINUTE, 0);
        cd.set(Calendar.SECOND, 0);
        return cd.getTime();
    }

    public static String parseDateTime(Date date, String format) {
        SimpleDateFormat obj = new SimpleDateFormat(format);
        try {
            if (date == null) {
                return "";
            }
            return obj.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDateTime(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat obj = new SimpleDateFormat(format);
        try {
            return obj.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date addDateDay(Date nowDay, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDay);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 获取两个时间相差的毫秒数
     *
     * @param start
     * @param end
     * @return
     */
    public static Long diffMills(Date start, Date end) {
        if (null == start || null == end) {
            return null;
        }

        return end.getTime() - start.getTime();
    }

    /**
     * 获取两个时间相差的天数
     *
     * @param start
     * @param end
     * @return
     */
    public static Integer diffDays(Date start, Date end) {
        if (null == start || null == end) {
            return null;
        }
        return (int) ((DateTimeUtil.getDateStart(end).getTime() - DateTimeUtil.getDateStart(start).getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 获取两个时间相差的分钟数
     *
     * @param start
     * @param end
     * @return
     */
    public static Integer diffMinute(Date start, Date end) {
        if (null == start || null == end) {
            return null;
        }
        return (int) ((DateTimeUtil.getDateStart(end).getTime() - DateTimeUtil.getDateStart(start).getTime()) / (1000 * 60));
    }

    /**
     * 获取两个时间相差的分钟数
     *
     * @param start
     * @param end
     * @return
     */
    public static Integer diffSecond(Date start, Date end) {
        if (null == start || null == end) {
            return null;
        }
        return (int) ((DateTimeUtil.getDateStart(end).getTime() - DateTimeUtil.getDateStart(start).getTime()) / 1000);
    }

    public static String getMonth(Date day) throws Exception {
        ParamCheck.nullCheck(day, "day");
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        int month = cal.get(Calendar.MONTH) + 1;
        return String.format("%02d", month);

    }

    public static Date getMonthStartTime(String month) {
        return DateTimeUtil.parseDateTime(month, DateTimeUtil.MONTH_FORMATOR);
    }
}
