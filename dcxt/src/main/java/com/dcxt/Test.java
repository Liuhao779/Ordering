package com.dcxt;

import com.dcxt.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Test {
    public static void main(String[]arge){

        UUID uuid = UUID.randomUUID();

//使用Date
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(Utils.uuid());
        System.out.println("当前时间：" + sdf.format(d)+uuid.toString().substring(0,3));
    }
}
