package com.onesignal.user.subscriptions;

import com.onesignal.core.BuildConfig;
import kotlin.Metadata;

/* compiled from: IPushSubscriptionObserver.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/user/subscriptions/IPushSubscriptionObserver;", "", "onPushSubscriptionChange", "", "state", "Lcom/onesignal/user/subscriptions/PushSubscriptionChangedState;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IPushSubscriptionObserver {
    void onPushSubscriptionChange(PushSubscriptionChangedState state);
}
