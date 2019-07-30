package org.sharebook.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

    private static DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static DateFormat complexDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String simpleDateFormat(Date date) {
        return simpleDateFormat.format(date);
    }

    public static String complexDateFormat(Date date) {
        return complexDateFormat.format(date);
    }
}
