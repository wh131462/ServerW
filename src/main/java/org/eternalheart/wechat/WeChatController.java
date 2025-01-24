package org.eternalheart.wechat;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/wechat")
public class WeChatController {

    private static final String TOKEN = "wh131462"; // 替换为你在微信后台配置的 Token

    /**
     * 校验微信服务器的请求（GET 方法）
     */
    @GetMapping
    public String validateWeChat(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr
    ) {
        if (checkSignature(signature, timestamp, nonce)) {
            return echostr; // 验证成功，返回 echostr
        }
        return "Invalid request";
    }

    /**
     * 处理微信消息（POST 方法）
     */
    @PostMapping
    public String handleMessage(@RequestBody String requestBody) {
        // 解析微信发来的 XML 消息
        Map<String, String> messageMap = WeChatMessageUtils.parseXml(requestBody);

        // 获取消息类型
        String msgType = messageMap.get("MsgType");
        String fromUser = messageMap.get("FromUserName");
        String toUser = messageMap.get("ToUserName");

        // 消息分发
        switch (msgType) {
            case "text": // 文本消息
                String content = messageMap.get("Content");
                return WeChatMessageUtils.buildTextMessage(toUser, fromUser, "您发送的是：" + content);
            case "event": // 事件推送
                String event = messageMap.get("Event");
                if ("subscribe".equals(event)) {
                    return WeChatMessageUtils.buildTextMessage(toUser, fromUser, "感谢关注！");
                }
                break;
            default:
                return WeChatMessageUtils.buildTextMessage(toUser, fromUser, "暂不支持该消息类型！");
        }

        return "success"; // 微信需要响应“success”表示处理完成
    }

    /**
     * 校验微信服务器请求是否合法
     */
    private boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = {TOKEN, timestamp, nonce};
        java.util.Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String s : arr) {
            content.append(s);
        }
        return WeChatMessageUtils.sha1(content.toString()).equals(signature);
    }

    /**
     * 处理文本消息
     */
    private String handleTextMessage(Map<String, String> messageMap) {
        String content = messageMap.get("Content");
        String fromUser = messageMap.get("FromUserName");
        String toUser = messageMap.get("ToUserName");

        // 示例：简单响应输入的消息
        return WeChatMessageUtils.buildTextMessage(toUser, fromUser, "您发送的是：" + content);
    }

    /**
     * 处理事件推送消息
     */
    private String handleEventMessage(Map<String, String> messageMap) {
        String event = messageMap.get("Event");
        String fromUser = messageMap.get("FromUserName");
        String toUser = messageMap.get("ToUserName");

        if ("subscribe".equals(event)) {
            return WeChatMessageUtils.buildTextMessage(toUser, fromUser, "感谢您的关注！");
        } else if ("unsubscribe".equals(event)) {
            // 取消关注不需要响应
            return "success";
        } else if ("CLICK".equals(event)) {
            String eventKey = messageMap.get("EventKey");
            return WeChatMessageUtils.buildTextMessage(toUser, fromUser, "您点击了菜单：" + eventKey);
        }

        return "success";
    }
}
