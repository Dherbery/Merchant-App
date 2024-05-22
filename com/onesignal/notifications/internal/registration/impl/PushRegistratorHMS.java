package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushRegistratorHMS.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorHMS;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/application/IApplicationService;)V", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHMSTokenTask", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerForPush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PushRegistratorHMS implements IPushRegistrator, IPushRegistratorCallback {
    private static final String HMS_CLIENT_APP_ID = "client/app_id";
    private final IApplicationService _applicationService;
    private final IDeviceService _deviceService;
    private WaiterWithValue<String> waiter;

    public PushRegistratorHMS(IDeviceService _deviceService, IApplicationService _applicationService) {
        Intrinsics.checkNotNullParameter(_deviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        this._deviceService = _deviceService;
        this._applicationService = _applicationService;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|28|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002b, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        com.onesignal.debug.internal.logging.Logging.error("HMS ApiException getting Huawei push token!", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r6.getStatusCode() == 907135000) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_ARGUMENTS_INVALID;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        r6 = new com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult(null, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_API_EXCEPTION_OTHER;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registerForPush(kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1
            if (r0 == 0) goto L14
            r0 = r6
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: com.huawei.hms.common.ApiException -> L2b
            goto L4a
        L2b:
            r6 = move-exception
            goto L4d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r3
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r6 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r6
            com.onesignal.core.internal.application.IApplicationService r6 = r5._applicationService     // Catch: com.huawei.hms.common.ApiException -> L2b
            android.content.Context r6 = r6.getAppContext()     // Catch: com.huawei.hms.common.ApiException -> L2b
            r0.label = r4     // Catch: com.huawei.hms.common.ApiException -> L2b
            java.lang.Object r6 = r5.getHMSTokenTask(r6, r0)     // Catch: com.huawei.hms.common.ApiException -> L2b
            if (r6 != r1) goto L4a
            return r1
        L4a:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r6 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r6     // Catch: com.huawei.hms.common.ApiException -> L2b
            goto L69
        L4d:
            java.lang.String r0 = "HMS ApiException getting Huawei push token!"
            r1 = r6
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.onesignal.debug.internal.logging.Logging.error(r0, r1)
            int r6 = r6.getStatusCode()
            r0 = 907135000(0x3611c818, float:2.1723154E-6)
            if (r6 != r0) goto L61
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_ARGUMENTS_INVALID
            goto L63
        L61:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_API_EXCEPTION_OTHER
        L63:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r0 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r0.<init>(r3, r6)
            r6 = r0
        L69:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.registerForPush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b8 A[Catch: all -> 0x00e5, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0013, B:9:0x001e, B:12:0x002d, B:13:0x00b4, B:15:0x00b8, B:19:0x00d7, B:20:0x0036, B:21:0x003d, B:22:0x003e, B:24:0x0049, B:27:0x0052, B:29:0x007e, B:32:0x009e, B:37:0x0019), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0013, B:9:0x001e, B:12:0x002d, B:13:0x00b4, B:15:0x00b8, B:19:0x00d7, B:20:0x0036, B:21:0x003d, B:22:0x003e, B:24:0x0049, B:27:0x0052, B:29:0x007e, B:32:0x009e, B:37:0x0019), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e A[Catch: all -> 0x00e5, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0009, B:8:0x0013, B:9:0x001e, B:12:0x002d, B:13:0x00b4, B:15:0x00b8, B:19:0x00d7, B:20:0x0036, B:21:0x003d, B:22:0x003e, B:24:0x0049, B:27:0x0052, B:29:0x007e, B:32:0x009e, B:37:0x0019), top: B:3:0x0005 }] */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.Object getHMSTokenTask(android.content.Context r11, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r12) throws com.huawei.hms.common.ApiException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback
    public Object fireCallback(String str, Continuation<? super Unit> continuation) {
        WaiterWithValue<String> waiterWithValue = this.waiter;
        if (waiterWithValue != null) {
            waiterWithValue.wake(str);
        }
        return Unit.INSTANCE;
    }
}
