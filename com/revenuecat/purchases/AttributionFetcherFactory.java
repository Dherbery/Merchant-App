package com.revenuecat.purchases;

import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributionFetcherFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/AttributionFetcherFactory;", "", "()V", "createAttributionFetcher", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AttributionFetcherFactory {
    public static final AttributionFetcherFactory INSTANCE = new AttributionFetcherFactory();

    /* compiled from: AttributionFetcherFactory.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AttributionFetcherFactory() {
    }

    public final DeviceIdentifiersFetcher createAttributionFetcher(Store store, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        int i = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i == 1) {
            return new GoogleDeviceIdentifiersFetcher(dispatcher);
        }
        if (i == 2) {
            try {
                Object newInstance = Class.forName("com.revenuecat.purchases.amazon.attribution.AmazonDeviceIdentifiersFetcher").getConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher");
                return (DeviceIdentifiersFetcher) newInstance;
            } catch (ClassNotFoundException e) {
                LogUtilsKt.errorLog("Make sure purchases-amazon is added as dependency", e);
                throw e;
            }
        }
        LogUtilsKt.errorLog$default("Incompatible store (" + store + ") used", null, 2, null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
