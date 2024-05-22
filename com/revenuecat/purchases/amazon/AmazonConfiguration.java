package com.revenuecat.purchases.amazon;

import android.content.Context;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.Store;

/* loaded from: classes5.dex */
public final class AmazonConfiguration extends PurchasesConfiguration {
    public AmazonConfiguration(Builder builder) {
        super(builder);
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends PurchasesConfiguration.Builder {
        public Builder(Context context, String str) {
            super(context, str);
            store(Store.AMAZON);
        }
    }
}
