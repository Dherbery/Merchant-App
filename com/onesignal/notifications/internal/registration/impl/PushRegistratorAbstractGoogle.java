package com.onesignal.notifications.internal.registration.impl;

import com.google.android.gms.iid.InstanceID;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushRegistratorAbstractGoogle.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b \u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ#\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0011\u0010 \u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_upgradePrompt", "Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;)V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "attemptRegistration", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "senderId", "currentRetry", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "internalRegisterForPush", "isValidProjectNumber", "", "pushStatusFromThrowable", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "throwable", "", "registerForPush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerInBackground", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PushRegistratorAbstractGoogle implements IPushRegistrator, IPushRegistratorCallback {
    private static final int REGISTRATION_RETRY_BACKOFF_MS = 10000;
    private static final int REGISTRATION_RETRY_COUNT = 5;
    private ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final GooglePlayServicesUpgradePrompt _upgradePrompt;

    @Override // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String str, Continuation<? super Unit> continuation) {
        return fireCallback$suspendImpl(this, str, continuation);
    }

    public abstract String getProviderName();

    public abstract Object getToken(String str, Continuation<? super String> continuation) throws ExecutionException, InterruptedException, IOException;

    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    public Object registerForPush(Continuation<? super IPushRegistrator.RegisterResult> continuation) {
        return registerForPush$suspendImpl(this, continuation);
    }

    public PushRegistratorAbstractGoogle(IDeviceService _deviceService, ConfigModelStore _configModelStore, GooglePlayServicesUpgradePrompt _upgradePrompt) {
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_upgradePrompt, "_upgradePrompt");
        this._deviceService = _deviceService;
        this._configModelStore = _configModelStore;
        this._upgradePrompt = _upgradePrompt;
    }

    static /* synthetic */ Object registerForPush$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, Continuation continuation) {
        if (!pushRegistratorAbstractGoogle._configModelStore.getModel().isInitializedWithRemote()) {
            return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.FIREBASE_FCM_INIT_ERROR);
        }
        if (!pushRegistratorAbstractGoogle._deviceService.getHasFCMLibrary()) {
            Logging.fatal$default("The Firebase FCM library is missing! Please make sure to include it in your project.", null, 2, null);
            return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.MISSING_FIREBASE_FCM_LIBRARY);
        }
        if (!pushRegistratorAbstractGoogle.isValidProjectNumber(pushRegistratorAbstractGoogle._configModelStore.getModel().getGoogleProjectNumber())) {
            Logging.error$default("Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.", null, 2, null);
            return new IPushRegistrator.RegisterResult(null, SubscriptionStatus.INVALID_FCM_SENDER_ID);
        }
        String googleProjectNumber = pushRegistratorAbstractGoogle._configModelStore.getModel().getGoogleProjectNumber();
        Intrinsics.checkNotNull(googleProjectNumber);
        return pushRegistratorAbstractGoogle.internalRegisterForPush(googleProjectNumber, continuation);
    }

    static /* synthetic */ Object fireCallback$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, String str, Continuation continuation) {
        throw new Exception("Google has no callback mechanism for push registration!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object internalRegisterForPush(java.lang.String r7, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1
            if (r0 == 0) goto L14
            r0 = r8
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r3) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r7 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L42
            goto L6c
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r7 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L42
            goto L5b
        L42:
            r8 = move-exception
            goto L7b
        L44:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.core.internal.device.IDeviceService r8 = r6._deviceService     // Catch: java.lang.Throwable -> L79
            boolean r8 = r8.isGMSInstalledAndEnabled()     // Catch: java.lang.Throwable -> L79
            if (r8 == 0) goto L5e
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L79
            r0.label = r3     // Catch: java.lang.Throwable -> L79
            java.lang.Object r8 = r6.registerInBackground(r7, r0)     // Catch: java.lang.Throwable -> L79
            if (r8 != r1) goto L5a
            return r1
        L5a:
            r7 = r6
        L5b:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r8 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r8     // Catch: java.lang.Throwable -> L42
            goto L78
        L5e:
            com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt r7 = r6._upgradePrompt     // Catch: java.lang.Throwable -> L79
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L79
            r0.label = r4     // Catch: java.lang.Throwable -> L79
            java.lang.Object r7 = r7.showUpdateGPSDialog(r0)     // Catch: java.lang.Throwable -> L79
            if (r7 != r1) goto L6b
            return r1
        L6b:
            r7 = r6
        L6c:
            java.lang.String r8 = "'Google Play services' app not installed or disabled on the device."
            com.onesignal.debug.internal.logging.Logging.error$default(r8, r5, r4, r5)     // Catch: java.lang.Throwable -> L42
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r8 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch: java.lang.Throwable -> L42
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.OUTDATED_GOOGLE_PLAY_SERVICES_APP     // Catch: java.lang.Throwable -> L42
            r8.<init>(r5, r0)     // Catch: java.lang.Throwable -> L42
        L78:
            return r8
        L79:
            r8 = move-exception
            r7 = r6
        L7b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not register with "
            r0.<init>(r1)
            java.lang.String r7 = r7.getProviderName()
            r0.append(r7)
            java.lang.String r7 = " due to an issue with your AndroidManifest.xml or with 'Google Play services'."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.error(r7, r8)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r7 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r8 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_INIT_ERROR
            r7.<init>(r5, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.internalRegisterForPush(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007f -> B:11:0x0082). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registerInBackground(java.lang.String r10, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1
            if (r0 == 0) goto L14
            r0 = r11
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1
            r0.<init>(r9, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r5 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L82
        L37:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3f:
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r5 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L69
        L4d:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r2 = r9
        L52:
            r5 = 5
            if (r11 >= r5) goto L87
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r4
            java.lang.Object r5 = r2.attemptRegistration(r10, r11, r0)
            if (r5 != r1) goto L64
            return r1
        L64:
            r8 = r2
            r2 = r10
            r10 = r11
            r11 = r5
            r5 = r8
        L69:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r11 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r11
            if (r11 == 0) goto L6e
            return r11
        L6e:
            int r11 = r10 + 1
            int r11 = r11 * 10000
            long r6 = (long) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r11 != r1) goto L82
            return r1
        L82:
            int r11 = r10 + 1
            r10 = r2
            r2 = r5
            goto L52
        L87:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r10 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r11 = 0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_INIT_ERROR
            r10.<init>(r11, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.registerInBackground(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptRegistration(java.lang.String r9, int r10, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.attemptRegistration(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SubscriptionStatus pushStatusFromThrowable(Throwable throwable) {
        String rootCauseMessage = AndroidUtils.INSTANCE.getRootCauseMessage(throwable);
        if (throwable instanceof IOException) {
            return Intrinsics.areEqual(rootCauseMessage, InstanceID.ERROR_SERVICE_NOT_AVAILABLE) ? SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE : Intrinsics.areEqual(rootCauseMessage, "AUTHENTICATION_FAILED") ? SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED : SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER;
        }
        return SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION;
    }

    private final boolean isValidProjectNumber(String senderId) {
        boolean z;
        try {
            Intrinsics.checkNotNull(senderId);
            Float.parseFloat(senderId);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        return z;
    }
}
