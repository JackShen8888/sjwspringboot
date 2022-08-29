package com.ft.ft_asset.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
@Slf4j
public class MD5Util {
    public static String getMd5SignStr(Map<String, Object> params) {

        String[] sortedKeys = params.keySet().toArray(new String[]{}); //将key取出放数组
        Arrays.sort(sortedKeys);// 排序请求参数
        StringBuilder s2 = new StringBuilder();
        for (String key : sortedKeys) {
            s2.append(key).append(params.get(key));   //name123sssssdf
        }
        if (s2.toString().trim().length() == 0) {
            return "";
        }
        return s2.toString();
    }
    public final static String MD5(String s) {
       char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
       try {
         byte[] btInput = s.getBytes();
         // 获得MD5摘要算法的 MessageDigest 对象
         MessageDigest mdInst = MessageDigest.getInstance("MD5");
         // 使用指定的字节更新摘要
         mdInst.update(btInput);
         // 获得密文
         byte[] md = mdInst.digest();
         // 把密文转换成十六进制的字符串形式
         int j = md.length;
         char str[] = new char[j * 2];
         int k = 0;
         for (int i = 0; i < j; i++) {
           byte byte0 = md[i];
           str[k++] = hexDigits[byte0 >>> 4 & 0xf];
           str[k++] = hexDigits[byte0 & 0xf];
         }
         return new String(str);
       } catch (Exception e) {
         e.printStackTrace();
         return null;
       }
     }

    public final static String MD5GateWay(String s) {
        //char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char hexDigits[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得二进制密文
            byte[] md = mdInst.digest();
            // 把二进制密文转换成三十二进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error("发生错误",e);
            return null;
        }
    }
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String getStringMD5(String str) {
        StringBuilder sb = new StringBuilder();

        try {
            byte[] data = str.getBytes("utf-8");
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            MD5.update(data);
            data = MD5.digest();

            for(int i = 0; i < data.length; ++i) {
                sb.append(HEX_DIGITS[(data[i] & 240) >> 4] + "" + HEX_DIGITS[data[i] & 15]);
            }
        } catch (Exception var5) {
        }

        return sb.toString();
    }
}
