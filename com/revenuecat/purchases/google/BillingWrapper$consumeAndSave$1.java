package com.revenuecat.purchases.google;

import com.revenuecat.purchases.common.caching.DeviceCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BillingWrapper.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class BillingWrapper$consumeAndSave$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BillingWrapper$consumeAndSave$1(Object obj) {
        super(1, obj, DeviceCache.class, "addSuccessfullyPostedToken", "addSuccessfullyPostedToken(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((DeviceCache) this.receiver).addSuccessfullyPostedToken(p0);
    }
}
