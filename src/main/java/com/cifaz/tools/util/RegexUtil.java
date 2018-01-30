package com.cifaz.tools.util;

import java.util.regex.Pattern;

public class RegexUtil {
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    public static final String REGEX_MOBILE = "^1[345678]\\d{9}$";
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    public static final String REGEX_CHINESE = "^[一-龥],{0,}$";
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    public static final String REGEX_IP_ADDR = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
    public static final String REGEX_IPV6_ADDR = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";

    public RegexUtil() {
    }

    public static boolean isUsername(String username) {
        return Pattern.matches("^[a-zA-Z]\\w{5,17}$", username);
    }

    public static boolean isPassword(String password) {
        return Pattern.matches("^[a-zA-Z0-9]{6,16}$", password);
    }

    public static boolean isMobile(String mobile) {
        return Pattern.matches("^1[345678]\\d{9}$", mobile);
    }

    public static boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);
    }

    public static boolean isChinese(String chinese) {
        return Pattern.matches("^[一-龥],{0,}$", chinese);
    }

    public static boolean isIDCard(String idCard) {
        return Pattern.matches("(^\\d{18}$)|(^\\d{15}$)", idCard);
    }

    public static boolean isUrl(String url) {
        return Pattern.matches("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?", url);
    }

    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches("^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$", ipAddr) || Pattern.matches("^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$", ipAddr);
    }

    public static void main(String[] args) {
        System.out.println(isIPAddr("5e:0:0:0:0:0:5668:eeee"));
    }
}
