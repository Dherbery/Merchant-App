package com.bleplx.adapter.utils;

import java.util.UUID;

/* loaded from: classes.dex */
public class UUIDConverter {
    private static String baseUUIDPrefix = "0000";
    private static String baseUUIDSuffix = "-0000-1000-8000-00805F9B34FB";

    public static UUID convert(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 4) {
            str = baseUUIDPrefix + str + baseUUIDSuffix;
        } else if (str.length() == 8) {
            str = str + baseUUIDSuffix;
        }
        try {
            return UUID.fromString(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static UUID[] convert(String... strArr) {
        UUID[] uuidArr = new UUID[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str == null) {
                return null;
            }
            if (str.length() == 4) {
                strArr[i] = baseUUIDPrefix + strArr[i] + baseUUIDSuffix;
            } else if (strArr[i].length() == 8) {
                strArr[i] = strArr[i] + baseUUIDSuffix;
            }
            try {
                uuidArr[i] = UUID.fromString(strArr[i]);
            } catch (Throwable unused) {
                return null;
            }
        }
        return uuidArr;
    }

    public static String fromUUID(UUID uuid) {
        return uuid.toString().toLowerCase();
    }
}
