package com.revenuecat.purchases;

import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchasesFactory.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class PurchasesFactory$createPaywallEventsManager$1 extends FunctionReferenceImpl implements Function1<String, PaywallStoredEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PurchasesFactory$createPaywallEventsManager$1(Object obj) {
        super(1, obj, PaywallStoredEvent.Companion.class, "fromString", "fromString(Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PaywallStoredEvent invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((PaywallStoredEvent.Companion) this.receiver).fromString(p0);
    }
}
