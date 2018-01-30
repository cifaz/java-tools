package com.cifaz.tools.util;

public class XssUtil {
    public XssUtil() {
    }

    public static String cleanXss(String value) {
        value = value.replaceAll("\\\"", "&quot;");
        value = value.replaceAll("&", "&amp;");
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("[\\\"\\'][\\s]*javascript:(.*)[\\\"\\']", "\"\"");
        return value;
    }
}
