package com.kmw.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConvert extends StringUtils {

    /**
     * 转换为Double类型
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Float类型
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Long类型
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    /**
     * 转换为Integer类型
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }

    /**
     * 将驼峰风格替换为下划线风格
     */
    public static String camelhumpToUnderline(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        str = String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == str.length() ? "" : "_");
        }
        return sb.toString();
    }

    /**
     * 将下划线风格替换为驼峰风格
     */
    public static String underlineToCamelhump(String name) {
        if (!name.contains("_")) return name;
        char[] buffer = name.toCharArray();
        int count = 0;
        boolean lastUnderscore = false;
        for (int i = 0; i < buffer.length; i++) {
            char c = buffer[i];
            if (c == '_') {
                lastUnderscore = true;
            } else {
                c = (lastUnderscore && count != 0) ? toUpperAscii(c)
                        : toLowerAscii(c);
                buffer[count++] = c;
                lastUnderscore = false;
            }
        }
        if (count != buffer.length) {
            buffer = subarray(buffer, 0, count);
        }
        return new String(buffer);
    }

    public static char[] subarray(char[] src, int offset, int len) {
        char[] dest = new char[len];
        System.arraycopy(src, offset, dest, 0, len);
        return dest;
    }

    public static boolean isLowercaseAlpha(char c) {
        return (c >= 'a') && (c <= 'z');
    }

    public static char toUpperAscii(char c) {
        if (isLowercaseAlpha(c)) {
            c -= (char) 0x20;
        }
        return c;
    }

    public static char toLowerAscii(char c) {
        if ((c >= 'A') && (c <= 'Z')) {
            c += (char) 0x20;
        }
        return c;
    }

 



}
