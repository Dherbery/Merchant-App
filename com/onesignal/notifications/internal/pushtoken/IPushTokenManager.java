package com.onesignal.notifications.internal.pushtoken;

import com.onesignal.notifications.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: IPushTokenManager.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;", "", "retrievePushToken", "Lcom/onesignal/notifications/internal/pushtoken/PushTokenResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IPushTokenManager {
    Object retrievePushToken(Continuation<? super PushTokenResponse> continuation);
}
