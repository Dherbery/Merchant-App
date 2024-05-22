package com.revenuecat.purchases.paywalls;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaywallPresentedCache.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048B@BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallPresentedCache;", "", "()V", "<set-?>", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "lastPaywallImpressionEvent", "cachePresentedPaywall", "", "paywallEvent", "getAndRemovePresentedEvent", "receiveEvent", NotificationCompat.CATEGORY_EVENT, "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PaywallPresentedCache {
    private PaywallEvent lastPaywallImpressionEvent;

    /* compiled from: PaywallPresentedCache.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaywallEventType.values().length];
            try {
                iArr[PaywallEventType.IMPRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallEventType.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final synchronized PaywallEvent getAndRemovePresentedEvent() {
        PaywallEvent paywallEvent;
        paywallEvent = this.lastPaywallImpressionEvent;
        this.lastPaywallImpressionEvent = null;
        return paywallEvent;
    }

    public final synchronized void cachePresentedPaywall(PaywallEvent paywallEvent) {
        Intrinsics.checkNotNullParameter(paywallEvent, "paywallEvent");
        this.lastPaywallImpressionEvent = paywallEvent;
    }

    public final synchronized void receiveEvent(PaywallEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.getType().ordinal()];
        if (i == 1) {
            LogUtilsKt.verboseLog("Caching paywall impression event.");
            this.lastPaywallImpressionEvent = event;
        } else if (i == 2) {
            LogUtilsKt.verboseLog("Clearing cached paywall impression event.");
            this.lastPaywallImpressionEvent = null;
        }
    }
}
