package com.onesignal.user.internal;

import com.onesignal.core.BuildConfig;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.subscriptions.ISmsSubscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmsSubscription.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/SmsSubscription;", "Lcom/onesignal/user/internal/Subscription;", "Lcom/onesignal/user/subscriptions/ISmsSubscription;", "model", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionModel;)V", "number", "", "getNumber", "()Ljava/lang/String;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsSubscription extends Subscription implements ISmsSubscription {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsSubscription(SubscriptionModel model) {
        super(model);
        Intrinsics.checkNotNullParameter(model, "model");
    }

    @Override // com.onesignal.user.subscriptions.ISmsSubscription
    public String getNumber() {
        return getModel().getAddress();
    }
}
