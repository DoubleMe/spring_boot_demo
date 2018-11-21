package com.chenhm.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author chen-hongmin
 * @date 2018/5/17 13:47
 * @since V1.0
 */
public class DateUtils {


    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";


    /**
     * string 转 date
     *
     * @param dateString dataString
     * @param format     格式化
     * @return date
     */
    public static Date parse(String dateString, String format) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date = simpleDateFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * date 转 string
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String target = simpleDateFormat.format(date);

        return target;
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static String timestamp() {

        return format(new Date(), YYYYMMDDHHMMSSSSS);
    }


    public static void main(String[] args) {

        int value = LocalDateTime.of(2018, 8, 5, 0, 0).getDayOfWeek().getValue();
        System.out.println(value);

    }
}
