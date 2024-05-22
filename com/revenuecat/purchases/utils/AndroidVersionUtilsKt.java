package com.revenuecat.purchases.utils;

import android.os.Build;
import kotlin.Metadata;

/* compiled from: AndroidVersionUtils.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"isAndroidNOrNewer", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AndroidVersionUtilsKt {
    public static final boolean isAndroidNOrNewer() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
