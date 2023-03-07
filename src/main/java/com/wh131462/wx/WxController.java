package com.wh131462.wx;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxController {
    @Autowired
    private WeixinService weixinService;

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String verify(@RequestParam(name = "signature") String signature,
                         @RequestParam(name = "timestamp") String timestamp,
                         @RequestParam(name = "nonce") String nonce,
                         @RequestParam(name = "echostr") String echostr) {
        return weixinService.verify(signature, timestamp, nonce, echostr);
    }

    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String handleWeixinMsg(HttpServletRequest request) {
        String xml = null;
        try {
            xml = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
            return weixinService.handleWeixinMsg(xml);
        } catch (IOException e) {
            // handle exception

        }
        return null;
    }
}
