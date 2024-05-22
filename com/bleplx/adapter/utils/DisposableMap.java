package com.bleplx.adapter.utils;

import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class DisposableMap {
    private final Map<String, Disposable> subscriptions = new HashMap();

    public synchronized void replaceSubscription(String str, Disposable disposable) {
        Disposable put = this.subscriptions.put(str, disposable);
        if (put != null && !put.isDisposed()) {
            put.dispose();
        }
    }

    public synchronized boolean removeSubscription(String str) {
        Disposable remove = this.subscriptions.remove(str);
        if (remove == null) {
            return false;
        }
        if (!remove.isDisposed()) {
            remove.dispose();
        }
        return true;
    }

    public synchronized void removeAllSubscriptions() {
        Iterator<Map.Entry<String, Disposable>> it = this.subscriptions.entrySet().iterator();
        while (it.hasNext()) {
            Disposable value = it.next().getValue();
            it.remove();
            if (!value.isDisposed()) {
                value.dispose();
            }
        }
    }
}
