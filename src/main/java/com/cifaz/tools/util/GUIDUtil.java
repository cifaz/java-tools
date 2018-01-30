package com.cifaz.tools.util;

import java.util.Random;
import java.util.UUID;

public class GUIDUtil {
    public GUIDUtil() {
    }

    public static String get36GUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        Random random = new Random();
        int factor = random.nextInt(9999);
        uuid = uuid + String.format("%04d", factor);
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(get36GUID());
    }
}
