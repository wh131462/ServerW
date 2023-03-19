package com.wh131462.controller.wx.utils.auth;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class WechatAuth {
    // 填写你在微信公众平台上设置的Token
    private static final String TOKEN = "*";

    public static boolean validate(String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数按照字典序排序
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(arr);

        // 将三个参数字符串拼接成一个字符串
        StringBuilder content = new StringBuilder();
        for (String str : arr) {
            content.append(str);
        }

        // 对拼接后的字符串进行sha1加密
        String encryptResult = sha1(content.toString());

        // 将加密后的字符串与signature对比
        return encryptResult != null && encryptResult.equals(signature);
    }

    // sha1加密
    private static String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = digest.digest(str.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    result.append("0");
                }
                result.append(hex);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
