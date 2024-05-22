package com.facebook.jni;

import com.bleplx.adapter.utils.Constants;

/* loaded from: classes.dex */
public class UnknownCppException extends CppException {
    public UnknownCppException() {
        super(Constants.BluetoothState.UNKNOWN);
    }

    public UnknownCppException(String str) {
        super(str);
    }
}
