package com.revenuecat.purchases.hybridcommon;

import java.util.Map;

/* loaded from: classes5.dex */
public interface OnResult {
    void onError(ErrorContainer errorContainer);

    void onReceived(Map<String, ?> map);
}
