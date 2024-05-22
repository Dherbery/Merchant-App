package com.bleplx.utils;

import com.facebook.react.bridge.ReadableArray;

/* loaded from: classes.dex */
public class ReadableArrayConverter {
    public static String[] toStringArray(ReadableArray readableArray) {
        String[] strArr = new String[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            strArr[i] = readableArray.getString(i);
        }
        return strArr;
    }
}
