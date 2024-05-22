package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushRegistratorADM.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorADM;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerForPush", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class PushRegistratorADM implements IPushRegistrator, IPushRegistratorCallback {
    private final IApplicationService _applicationService;
    private WaiterWithValue<String> waiter;

    public PushRegistratorADM(IApplicationService _applicationService) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        this._applicationService = _applicationService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, java.lang.String] */
    @Override // com.onesignal.notifications.internal.registration.IPushRegistrator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registerForPush(kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1
            if (r0 == 0) goto L14
            r0 = r9
            com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$1
            r0.<init>(r8, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L98
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r5
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r9
            com.onesignal.common.threading.WaiterWithValue r9 = new com.onesignal.common.threading.WaiterWithValue
            r9.<init>()
            r8.waiter = r9
            com.amazon.device.messaging.ADM r9 = new com.amazon.device.messaging.ADM
            com.onesignal.core.internal.application.IApplicationService r2 = r8._applicationService
            android.content.Context r2 = r2.getAppContext()
            r9.<init>(r2)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.lang.String r6 = r9.getRegistrationId()
            r2.element = r6
            T r6 = r2.element
            if (r6 == 0) goto L80
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "ADM Already registered with ID:"
            r9.<init>(r0)
            T r0 = r2.element
            java.lang.String r0 = (java.lang.String) r0
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r5, r4, r5)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            T r0 = r2.element
            java.lang.String r0 = (java.lang.String) r0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            r9.<init>(r0, r1)
            goto Lc9
        L80:
            r9.startRegister()
            com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$2 r9 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorADM$registerForPush$2
            r9.<init>(r2, r8, r5)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r0.L$0 = r2
            r0.label = r3
            r6 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.withTimeout(r6, r9, r0)
            if (r9 != r1) goto L97
            return r1
        L97:
            r0 = r2
        L98:
            T r9 = r0.element
            if (r9 == 0) goto Lbd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "ADM registered with ID:"
            r9.<init>(r1)
            T r1 = r0.element
            java.lang.String r1 = (java.lang.String) r1
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.onesignal.debug.internal.logging.Logging.error$default(r9, r5, r4, r5)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            T r0 = r0.element
            java.lang.String r0 = (java.lang.String) r0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            r9.<init>(r0, r1)
            goto Lc9
        Lbd:
            java.lang.String r9 = "com.onesignal.ADMMessageHandler timed out, please check that your have the receiver, service, and your package name matches(NOTE: Case Sensitive) per the OneSignal instructions."
            com.onesignal.debug.internal.logging.Logging.error$default(r9, r5, r4, r5)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.ERROR
            r9.<init>(r5, r0)
        Lc9:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorADM.registerForPush(kotlin.coroutines.Continuation):java.lang.Object");
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
