package com.wh131462.wx;
import com.wh131462.utils.LunarUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
public class AutoReplyController {
    @PostMapping("/wx/today")
    public ResponseEntity<String> handlePostRequest(@RequestBody String requestBody) {
        LunarUtils lunar=new LunarUtils();
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
        //初始化农历信息
        lunar.initLunarCalendarInfo(sm.format(new Date()));
        // 处理请求体并返回响应
        return ResponseEntity.ok("今天是"+lunar.getFullLunarDate());
    }
}
