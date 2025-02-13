package com.facebook.react.runtime.internal.bolts;

/* loaded from: classes3.dex */
public class Capture<T> {
    private T value;

    public Capture() {
    }

    public Capture(T t) {
        this.value = t;
    }

    public T get() {
        return this.value;
    }

    public void set(T t) {
        this.value = t;
    }
}
