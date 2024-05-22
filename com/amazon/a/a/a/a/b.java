package com.amazon.a.a.a.a;

/* compiled from: ActivityLifeCycleEventIdentity.java */
/* loaded from: classes.dex */
public enum b implements com.amazon.a.a.c.b {
    CREATE,
    DESTROY,
    RESUME,
    PAUSE,
    START,
    STOP;

    @Override // java.lang.Enum
    public String toString() {
        return "ACTIVITY_" + name();
    }
}
