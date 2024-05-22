package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PackageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OfferingParser.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toPackageType", "Lcom/revenuecat/purchases/PackageType;", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class OfferingParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageType toPackageType(String str) {
        PackageType packageType;
        PackageType[] values = PackageType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                packageType = null;
                break;
            }
            packageType = values[i];
            if (Intrinsics.areEqual(packageType.getIdentifier(), str)) {
                break;
            }
            i++;
        }
        return packageType == null ? StringsKt.startsWith$default(str, "$rc_", false, 2, (Object) null) ? PackageType.UNKNOWN : PackageType.CUSTOM : packageType;
    }
}
