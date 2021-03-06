package com.newproject.utils;

import android.content.Context;


import com.newproject.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* * 日期处理工具类
 *
 * @author whm
 *
 */
public class DateUtils {
    public static final String YMD = "yyyyMMdd";
    public static final String YMD_YEAR = "yyyy";
    public static final String YMD_BREAK = "yyyy-MM-dd";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String YMDHMS_BREAK = "yyyy-MM-dd HH:mm:ss";
    public static final String YMDHMS_BREAK_HALF = "yyyy-MM-dd HH:mm";

    /**
     * 计算时间差
     */
    public static final int CAL_MINUTES = 1000 * 60;
    public static final int CAL_HOURS = 1000 * 60 * 60;
    public static final int CAL_DAYS = 1000 * 60 * 60 * 24;

    /**
     * 获取当前时间格式化后的值
     *
     * @param pattern
     * @return
     */
    public static String getNowDateText(String pattern) {
        SimpleDateFormat sdf = getSimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    /**
     * 获取日期格式化后的值
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateText(Date date, String pattern) {
        SimpleDateFormat sdf = getSimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串时间转换成Date格式
     *
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date getDate(String date, String pattern) throws ParseException {
        SimpleDateFormat sdf = getSimpleDateFormat(pattern);
        return sdf.parse(date);
    }

    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 获取时间戳
     *
     * @param date
     * @return
     */
    public static Long getTime(Date date) {
        return date.getTime();
    }

    /**
     * 计算时间差
     *
     * @param startDate
     * @param endDate
     * @param calType   计算类型,按分钟、小时、天数计算
     * @return
     */
    public static int calDiffs(Date startDate, Date endDate, int calType) {
        Long start = DateUtils.getTime(startDate);
        Long end = DateUtils.getTime(endDate);
        int diff = (int) ((end - start) / calType);
        return diff;
    }

    /**
     * 计算时间差值以某种约定形式显示
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String timeDiffText(Date startDate, Date endDate, Context context) {
        int calDiffs = DateUtils.calDiffs(startDate, endDate, DateUtils.CAL_MINUTES);
        if (calDiffs == 0) {
            return  context.getString(R.string.just);
        }
        if (calDiffs < 60) {
            return calDiffs +  context.getString(R.string.minutes_ago);
        }
        calDiffs = DateUtils.calDiffs(startDate, endDate, DateUtils.CAL_HOURS);
        if (calDiffs < 24) {
            return calDiffs + context.getString(R.string.hours_before);
        }
        if (calDiffs < 48) {
            return context.getString(R.string.yesterday);
        }
        return DateUtils.getDateText(startDate, DateUtils.YMDHMS_BREAK_HALF);
    }

    /**
     * 显示某种约定后的时间值,类似微信朋友圈发布说说显示的时间那种
     *
     * @param date
     * @return
     */
    public static String showTimeText(Date date, Context context) {
        return DateUtils.timeDiffText(date, new Date(), context);
    }

    public static void main(String[] args) throws ParseException {
        Date start = DateUtils.getDate("2017-07-05 10:54", DateUtils.YMDHMS_BREAK_HALF);
//        System.out.println(DateUtils.showTimeText(start));
    }

    //十位时间戳字 转年月日 时 分
    public static String toNian(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    //十位时间戳字 转年月日 时 分
    public static String towNian(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    //十位时间戳字符串转小时分钟秒
    public static String Hourmin(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    //十位时间戳字符串转年月
    public static String YearMon(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    //十位时间戳字符串转月日
    public static String MonthDay(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("MM月dd日");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }
} 