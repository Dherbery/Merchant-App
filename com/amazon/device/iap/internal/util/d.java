package com.amazon.device.iap.internal.util;

/* compiled from: ReceiptVersion.java */
/* loaded from: classes.dex */
public enum d {
    LEGACY(0),
    V1(1),
    V2(2),
    V3(3);

    private int e;

    d(int i) {
        this.e = i;
    }

    int a() {
        return this.e;
    }

    public boolean a(d dVar) {
        return dVar != null && this.e < dVar.e;
    }
}
