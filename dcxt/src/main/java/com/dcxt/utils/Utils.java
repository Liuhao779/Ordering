package com.dcxt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
public class Utils {
    public static String uuid(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(d);
        UUID uuid = UUID.randomUUID();
        format+=uuid.toString().substring(0,3);
        return format;
    }
}
