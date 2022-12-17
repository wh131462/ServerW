package com.wh131462.wx;
import com.wh131462.*;
import com.wh131462.utils.LunarUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoReply {
    public static void main(String[] args) {
        LunarUtils lunar=new LunarUtils();
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
        lunar.initLunarCalendarInfo(sm.format(new Date()));
        System.out.println("今天是"+lunar.getFullLunarDate());
    }
}
