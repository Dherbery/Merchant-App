package com.onesignal.notifications.internal.pushtoken;

import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushTokenManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0011\u0010\u0016\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/onesignal/notifications/internal/pushtoken/PushTokenManager;", "Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;", "_pushRegistrator", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "(Lcom/onesignal/notifications/internal/registration/IPushRegistrator;Lcom/onesignal/core/internal/device/IDeviceService;)V", "pushToken", "", "getPushToken", "()Ljava/lang/String;", "setPushToken", "(Ljava/lang/String;)V", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "getPushTokenStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setPushTokenStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "pushStatusRuntimeError", "", "status", "retrievePushToken", "Lcom/onesignal/notifications/internal/pushtoken/PushTokenResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PushTokenManager implements IPushTokenManager {
    private final IDeviceService _deviceService;
    private final IPushRegistrator _pushRegistrator;
    private String pushToken;
    private SubscriptionStatus pushTokenStatus;

    /* compiled from: PushTokenManager.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IDeviceService.AndroidSupportLibraryStatus.values().length];
            iArr[IDeviceService.AndroidSupportLibraryStatus.MISSING.ordinal()] = 1;
            iArr[IDeviceService.AndroidSupportLibraryStatus.OUTDATED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PushTokenManager(IPushRegistrator _pushRegistrator, IDeviceService _deviceService) {
        Intrinsics.checkNotNullParameter(_pushRegistrator, "_pushRegistrator");
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        this._pushRegistrator = _pushRegistrator;
        this._deviceService = _deviceService;
        this.pushTokenStatus = SubscriptionStatus.NO_PERMISSION;
    }

    public final SubscriptionStatus getPushTokenStatus() {
        return this.pushTokenStatus;
    }

    public final void setPushTokenStatus(SubscriptionStatus subscriptionStatus) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "<set-?>");
        this.pushTokenStatus = subscriptionStatus;
    }

    public final String getPushToken() {
        return this.pushToken;
    }

    public final void setPushToken(String str) {
        this.pushToken = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.onesignal.notifications.internal.pushtoken.IPushTokenManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object retrievePushToken(kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.pushtoken.PushTokenResponse> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1
            if (r0 == 0) goto L14
            r0 = r6
            com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1 r0 = (com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1 r0 = new com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.onesignal.notifications.internal.pushtoken.PushTokenManager r0 = (com.onesignal.notifications.internal.pushtoken.PushTokenManager) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5b
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.core.internal.device.IDeviceService r6 = r5._deviceService
            com.onesignal.core.internal.device.IDeviceService$AndroidSupportLibraryStatus r6 = r6.getAndroidSupportLibraryStatus()
            int[] r2 = com.onesignal.notifications.internal.pushtoken.PushTokenManager.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r2[r6]
            r2 = 2
            r4 = 0
            if (r6 == r3) goto Lbc
            if (r6 == r2) goto Lb2
            com.onesignal.notifications.internal.registration.IPushRegistrator r6 = r5._pushRegistrator
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.registerForPush(r0)
            if (r6 != r1) goto L5a
            return r1
        L5a:
            r0 = r5
        L5b:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r6 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r6
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            int r1 = r1.getValue()
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            int r2 = r2.getValue()
            if (r1 != r2) goto L74
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            r0.pushTokenStatus = r1
            goto Lab
        L74:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            int r1 = r1.getValue()
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            int r2 = r2.getValue()
            if (r1 >= r2) goto L9d
            java.lang.String r1 = r0.pushToken
            if (r1 != 0) goto Lab
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r0.pushTokenStatus
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.NO_PERMISSION
            if (r1 == r2) goto L96
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r0.pushTokenStatus
            boolean r1 = r0.pushStatusRuntimeError(r1)
            if (r1 == 0) goto Lab
        L96:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            r0.pushTokenStatus = r1
            goto Lab
        L9d:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r0.pushTokenStatus
            boolean r1 = r0.pushStatusRuntimeError(r1)
            if (r1 == 0) goto Lab
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            r0.pushTokenStatus = r1
        Lab:
            java.lang.String r6 = r6.getId()
            r0.pushToken = r6
            goto Lc6
        Lb2:
            java.lang.String r6 = "The included Android Support Library is too old or incomplete. Please update to the 26.0.0 revision or newer."
            com.onesignal.debug.internal.logging.Logging.fatal$default(r6, r4, r2, r4)
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.OUTDATED_ANDROID_SUPPORT_LIBRARY
            r5.pushTokenStatus = r6
            goto Lc5
        Lbc:
            java.lang.String r6 = "Could not find the Android Support Library. Please make sure it has been correctly added to your project."
            com.onesignal.debug.internal.logging.Logging.fatal$default(r6, r4, r2, r4)
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.MISSING_ANDROID_SUPPORT_LIBRARY
            r5.pushTokenStatus = r6
        Lc5:
            r0 = r5
        Lc6:
            com.onesignal.notifications.internal.pushtoken.PushTokenResponse r6 = new com.onesignal.notifications.internal.pushtoken.PushTokenResponse
            java.lang.String r1 = r0.pushToken
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = r0.pushTokenStatus
            r6.<init>(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.pushtoken.PushTokenManager.retrievePushToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean pushStatusRuntimeError(SubscriptionStatus status) {
        return status.getValue() < -6;
    }
}
