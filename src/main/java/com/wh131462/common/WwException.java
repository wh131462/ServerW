package com.wh131462.common;


import com.wh131462.utils.DateUtil;

import java.util.Date;

public class WwException extends Exception{
    private String message;
    public WwException(String message){
        String time= DateUtil.getFormattedTime("","");
        String template = """
            Error: {0} from WwException at {1}
        """;
        this.message=template.replace("{0}",message).replace("{1}",time);
    }

    public String getMessage(){
        return this.message;
    }
}
