package com.wh131462.wx;

public interface WeixinService {
    String handleWeixinMsg(String xml);

    // 处理文本消息
    String processTextMessage(String message);

    // 处理图片消息
    String processImageMessage(String message);

    // 处理语音消息
    String processVoiceMessage(String message);

    // 处理视频消息
    String processVideoMessage(String message);

    // 处理小视频消息
    String processShortVideoMessage(String message);

    // 处理地理位置消息
    String processLocationMessage(String message);

    // 处理链接消息
    String processLinkMessage(String message);

    // 处理事件消息
    String processEventMessage(String message);

    String verify(String signature, String timestamp, String nonce, String echostr);
}
