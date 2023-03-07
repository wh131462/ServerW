package com.wh131462.wx;
import com.wh131462.utils.LunarUtils;
import com.wh131462.wx.utils.auth.WechatAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
public class AutoReplyController {
    /**
     * 微信开发者的初始化校验
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/wx/initAuth")
    public String verify(@RequestParam(name = "signature") String signature,
                         @RequestParam(name = "timestamp") String timestamp,
                         @RequestParam(name = "nonce") String nonce,
                         @RequestParam(name = "echostr") String echostr) {
        if (WechatAuth.validate(signature, timestamp, nonce)) {
            // 如果校验成功，则返回echostr，表示接入成功
            return echostr;
        } else {
            // 如果校验失败，则返回空字符串
            return "";
        }
    }

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
