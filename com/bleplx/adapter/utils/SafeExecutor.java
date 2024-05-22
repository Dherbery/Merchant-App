package com.bleplx.adapter.utils;

import com.bleplx.adapter.OnErrorCallback;
import com.bleplx.adapter.OnSuccessCallback;
import com.bleplx.adapter.errors.BleError;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class SafeExecutor<T> {
    private final OnErrorCallback errorCallback;
    private final OnSuccessCallback<T> successCallback;
    private final AtomicBoolean wasExecuted = new AtomicBoolean(false);

    public SafeExecutor(OnSuccessCallback<T> onSuccessCallback, OnErrorCallback onErrorCallback) {
        this.successCallback = onSuccessCallback;
        this.errorCallback = onErrorCallback;
    }

    public void success(T t) {
        OnSuccessCallback<T> onSuccessCallback;
        if (!this.wasExecuted.compareAndSet(false, true) || (onSuccessCallback = this.successCallback) == null) {
            return;
        }
        onSuccessCallback.onSuccess(t);
    }

    public void error(BleError bleError) {
        OnErrorCallback onErrorCallback;
        if (!this.wasExecuted.compareAndSet(false, true) || (onErrorCallback = this.errorCallback) == null) {
            return;
        }
        onErrorCallback.onError(bleError);
    }
}
