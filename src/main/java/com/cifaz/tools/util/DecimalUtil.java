package com.cifaz.tools.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalUtil {
    private DecimalUtil() {
    }

    public static String format(Number data, int digits, boolean plus) {
        if (data == null) {
            return null;
        } else {
            NumberFormat df = DecimalFormat.getInstance(Locale.CHINA);
            df.setRoundingMode(RoundingMode.HALF_UP);
            df.setMinimumFractionDigits(digits);
            df.setMaximumFractionDigits(digits);
            String str = df.format(data);
            if (data.toString().indexOf("-") == -1 && plus) {
                str = "+" + str;
            }

            return formatZero(str);
        }
    }

    public static String format(Number data, int digits) {
        return format(data, digits, false);
    }

    public static String format(Number data, String format, boolean plus) {
        if (data == null) {
            return null;
        } else {
            String ds = data.toString();
            BigDecimal bd = new BigDecimal(ds);
            int trailCount = format.indexOf(".");
            if (trailCount > 0) {
                trailCount = format.length() - trailCount - 1;
                bd = bd.setScale(trailCount, 4);
            }

            DecimalFormat f = new DecimalFormat(format);
            String str = f.format(bd);
            if (ds.indexOf("-") == -1 && plus) {
                str = "+" + str;
            }

            str = formatZero(str);
            return str;
        }
    }

    public static String format(Number data, String format) {
        return format(data, format, false);
    }

    private static String formatZero(String str) {
        Matcher matcher = Pattern.compile("[1-9]").matcher(str);
        return !matcher.find() ? str.replaceAll("-", "") : str;
    }

    public static String subZeroAndDot(String str) {
        if (str.indexOf(".") > 0) {
            str = str.replaceAll("0+?$", "");
            str = str.replaceAll("[.]$", "");
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(format((Number) null, 2));
        System.out.println(format(new BigDecimal(1111108.232D), 2));
        System.out.println(format(new BigDecimal(1111108.232D), "0.0"));
        System.out.println(format(new BigDecimal(8.232D), "00.0"));
    }
}
