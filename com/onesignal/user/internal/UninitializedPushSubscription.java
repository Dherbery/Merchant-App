package com.onesignal.user.internal;

import com.onesignal.core.BuildConfig;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PushSubscription.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/onesignal/user/internal/UninitializedPushSubscription;", "Lcom/onesignal/user/internal/PushSubscription;", "()V", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class UninitializedPushSubscription extends PushSubscription {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: PushSubscription.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/UninitializedPushSubscription$Companion;", "", "()V", "createFakePushSub", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SubscriptionModel createFakePushSub() {
            SubscriptionModel subscriptionModel = new SubscriptionModel();
            subscriptionModel.setId("");
            subscriptionModel.setType(SubscriptionType.PUSH);
            subscriptionModel.setOptedIn(false);
            subscriptionModel.setAddress("");
            return subscriptionModel;
        }
    }

    public UninitializedPushSubscription() {
        super(INSTANCE.createFakePushSub());
    }
}
