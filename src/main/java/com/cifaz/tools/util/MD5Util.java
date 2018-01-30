package com.cifaz.tools.util;

import java.security.MessageDigest;

public class MD5Util {
    public MD5Util() {
    }

    public static String getMD5(String msg) throws MD5Util.MD5Exception {
        if (msg == null) {
            throw new MD5Util.MD5Exception("Message for md5 calculation is null.");
        } else {
            byte[] source = msg.getBytes();
            String s = null;
            char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(source);
                byte[] tmp = md.digest();
                char[] str = new char[32];
                int k = 0;

                for (int i = 0; i < 16; ++i) {
                    byte byte0 = tmp[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 15];
                    str[k++] = hexDigits[byte0 & 15];
                }

                s = new String(str);
                return s;
            } catch (Exception var10) {
                throw new MD5Util.MD5Exception("Calculate MD5 failed.", var10);
            }
        }
    }

    public static class MD5Exception extends Exception {
        private static final long serialVersionUID = 1L;

        public MD5Exception() {
        }

        public MD5Exception(String message) {
            super(message);
        }

        public MD5Exception(String message, Throwable cause) {
            super(message, cause);
        }

        public MD5Exception(Throwable cause) {
            super(cause);
        }
    }
}
