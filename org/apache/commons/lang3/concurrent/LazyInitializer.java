package org.apache.commons.lang3.concurrent;

/* loaded from: classes6.dex */
public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private volatile T object;

    protected abstract T initialize() throws ConcurrentException;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t = this.object;
        if (t == null) {
            synchronized (this) {
                t = this.object;
                if (t == null) {
                    t = initialize();
                    this.object = t;
                }
            }
        }
        return t;
    }
}
