package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.ScanResultInterface;

/* loaded from: classes5.dex */
public interface ScanFilterInterface {
    boolean isAllFieldsEmpty();

    boolean matches(ScanResultInterface scanResultInterface);
}
