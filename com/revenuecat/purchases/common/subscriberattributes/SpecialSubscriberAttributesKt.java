package com.revenuecat.purchases.common.subscriberattributes;

import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpecialSubscriberAttributes.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getSubscriberAttributeKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class SpecialSubscriberAttributesKt {
    public static final SubscriberAttributeKey getSubscriberAttributeKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Intrinsics.areEqual(str, ReservedSubscriberAttribute.EMAIL.getValue()) ? SubscriberAttributeKey.Email.INSTANCE : Intrinsics.areEqual(str, ReservedSubscriberAttribute.DISPLAY_NAME.getValue()) ? SubscriberAttributeKey.DisplayName.INSTANCE : Intrinsics.areEqual(str, ReservedSubscriberAttribute.PHONE_NUMBER.getValue()) ? SubscriberAttributeKey.PhoneNumber.INSTANCE : Intrinsics.areEqual(str, ReservedSubscriberAttribute.FCM_TOKENS.getValue()) ? SubscriberAttributeKey.FCMTokens.INSTANCE : new SubscriberAttributeKey.Custom(str);
    }
}
