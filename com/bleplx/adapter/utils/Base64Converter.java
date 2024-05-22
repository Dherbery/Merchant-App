package com.bleplx.adapter.utils;

import android.util.Base64;

/* loaded from: classes.dex */
public class Base64Converter {
    public static String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] decode(String str) {
        return Base64.decode(str, 2);
    }
}
