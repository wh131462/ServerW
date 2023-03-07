package com.wh131462.wx;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

@Service
public class WxService implements WeixinService {

    @Override
    public String handleWeixinMsg(String xml) {
        try {
            Document doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement();
            String msgType = root.elementText("MsgType");
            switch(msgType){
                case "text":

                    break;
            }
        } catch (Exception e) {
            // handle exception
        }
        return null;
    }

    @Override
    public String processTextMessage(String message) {
        return null;
    }

    @Override
    public String processImageMessage(String message) {
        return null;
    }

    @Override
    public String processVoiceMessage(String message) {
        return null;
    }

    @Override
    public String processVideoMessage(String message) {
        return null;
    }

    @Override
    public String processShortVideoMessage(String message) {
        return null;
    }

    @Override
    public String processLocationMessage(String message) {
        return null;
    }

    @Override
    public String processLinkMessage(String message) {
        return null;
    }

    @Override
    public String processEventMessage(String message) {
        return null;
    }

    @Override
    public String verify(String signature, String timestamp, String nonce, String echostr) {
        return null;
    }


}