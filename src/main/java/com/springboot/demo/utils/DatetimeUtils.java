package com.springboot.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtils {
    public static String dateFormatStr(Date date)
    {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
