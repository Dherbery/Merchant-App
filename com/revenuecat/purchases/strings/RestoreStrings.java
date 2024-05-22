package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* compiled from: RestoreStrings.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/strings/RestoreStrings;", "", "()V", "EXTRA_QUERY_PURCHASE_HISTORY_RESPONSE", "", "PURCHASE_HISTORY_EMPTY", "PURCHASE_HISTORY_RETRIEVED", "PURCHASE_RESTORED", "QUERYING_INAPP_ERROR", "QUERYING_PURCHASE", "QUERYING_PURCHASE_HISTORY", "QUERYING_PURCHASE_WITH_HASH", "QUERYING_PURCHASE_WITH_TYPE", "QUERYING_SUBS_ERROR", "RESTORING_PURCHASE", "RESTORING_PURCHASE_ERROR", "SHARING_ACC_RESTORE_FALSE", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class RestoreStrings {
    public static final String EXTRA_QUERY_PURCHASE_HISTORY_RESPONSE = "BillingClient queryPurchaseHistory has returned more than once, with result: %s. More info here: https://rev.cat/google-duplicated-listener-timeouts";
    public static final RestoreStrings INSTANCE = new RestoreStrings();
    public static final String PURCHASE_HISTORY_EMPTY = "Purchase history is empty.";
    public static final String PURCHASE_HISTORY_RETRIEVED = "Purchase history retrieved %s";
    public static final String PURCHASE_RESTORED = "Purchase %s restored";
    public static final String QUERYING_INAPP_ERROR = "Error when querying inapps. %s";
    public static final String QUERYING_PURCHASE = "Querying purchases";
    public static final String QUERYING_PURCHASE_HISTORY = "Querying purchase history for type %s";
    public static final String QUERYING_PURCHASE_WITH_HASH = "Purchase of type %s with hash %s";
    public static final String QUERYING_PURCHASE_WITH_TYPE = "Querying Purchase with %s and type %s";
    public static final String QUERYING_SUBS_ERROR = "Error when querying subscriptions. %s";
    public static final String RESTORING_PURCHASE = "Restoring purchases";
    public static final String RESTORING_PURCHASE_ERROR = "Error restoring purchase: %s. Error: %s";
    public static final String SHARING_ACC_RESTORE_FALSE = "allowSharingPlayStoreAccount is set to false and restorePurchases has been called. This will 'alias' any app user id's sharing the same receipt. Are you sure you want to do this? More info here: https://errors.rev.cat/allowsSharingPlayStoreAccount";

    private RestoreStrings() {
    }
}
