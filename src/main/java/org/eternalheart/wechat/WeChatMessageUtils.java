package org.eternalheart.wechat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class WeChatMessageUtils {

    /**
     * 解析微信 XML 消息字符串
     */
    public static Map<String, String> parseXml(String xml) {
        Map<String, String> map = new HashMap<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));
            NodeList nodes = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                if (nodes.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    map.put(nodes.item(i).getNodeName(), nodes.item(i).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 构建文本消息响应
     */
    public static String buildTextMessage(String toUser, String fromUser, String content) {
        return "<xml>" +
                "<ToUserName><![CDATA[" + toUser + "]]></ToUserName>" +
                "<FromUserName><![CDATA[" + fromUser + "]]></FromUserName>" +
                "<CreateTime>" + System.currentTimeMillis() / 1000 + "</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[" + content + "]]></Content>" +
                "</xml>";
    }

    /**
     * SHA1 加密方法
     */
    public static String sha1(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] result = digest.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
