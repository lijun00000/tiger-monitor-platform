package com.tiger.monitor.platform.tigermonitorplatform.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    public static String formatTimeHHmmss(String dateString) {
        String format="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            format = simpleDateFormat.format(parseUTCText(dateString));
        }catch (Exception e){
            e.printStackTrace();
        }
        return format;
    }


    public static String formatTimeHHmmss(long dateTime) {
        String format="";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            format = simpleDateFormat.format(new Date(dateTime ));
        }catch (Exception e){
            e.printStackTrace();
        }
        return format;
    }



    public static Date parseUTCText(String text)  {
        Date date =null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            if (text.indexOf(".") > -1) {
                String prefix = text.substring(0, text.indexOf("."));
                String suffix = text.substring(text.indexOf("."));
                if (suffix.length() >= 5) {
                    suffix = suffix.substring(0, 4) + "Z";
                } else {
                    int len = 5 - suffix.length();
                    String temp = "";
                    temp += suffix.substring(0, suffix.length() - 1);
                    for (int i = 0; i < len; i++) {
                        temp += "0";
                    }
                    suffix = temp + "Z";
                }
                text = prefix + suffix;
            } else {
                text = text.substring(0, text.length() - 1) + ".000Z";
            }
            date = sdf.parse(text);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}
