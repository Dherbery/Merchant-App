package com.onesignal.notifications.internal.receivereceipt.impl;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.NetworkType;
import androidx.work.WorkerParameters;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReceiveReceiptWorkManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager;", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "maxDelay", "", "minDelay", "buildConstraints", "Landroidx/work/Constraints;", "enqueueReceiveReceipt", "", "notificationId", "", "Companion", "ReceiveReceiptWorker", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceiveReceiptWorkManager implements IReceiveReceiptWorkManager {
    private static final String OS_APP_ID = "os_app_id";
    private static final String OS_NOTIFICATION_ID = "os_notification_id";
    private static final String OS_SUBSCRIPTION_ID = "os_subscription_id";
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final int maxDelay;
    private final int minDelay;

    public ReceiveReceiptWorkManager(IApplicationService _applicationService, ConfigModelStore _configModelStore, ISubscriptionManager _subscriptionManager) {
        Intrinsics.checkNotNullParameter(_applicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(_configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(_subscriptionManager, "_subscriptionManager");
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        this._subscriptionManager = _subscriptionManager;
        this.maxDelay = 25;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        if ((r0.length() == 0) != false) goto L16;
     */
    @Override // com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void enqueueReceiveReceipt(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "notificationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.onesignal.core.internal.config.ConfigModelStore r0 = r8._configModelStore
            com.onesignal.common.modeling.Model r0 = r0.getModel()
            com.onesignal.core.internal.config.ConfigModel r0 = (com.onesignal.core.internal.config.ConfigModel) r0
            boolean r0 = r0.getReceiveReceiptEnabled()
            r1 = 2
            r2 = 0
            if (r0 != 0) goto L1b
            java.lang.String r9 = "sendReceiveReceipt disabled"
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r2, r1, r2)
            return
        L1b:
            com.onesignal.core.internal.config.ConfigModelStore r0 = r8._configModelStore
            com.onesignal.common.modeling.Model r0 = r0.getModel()
            com.onesignal.core.internal.config.ConfigModel r0 = (com.onesignal.core.internal.config.ConfigModel) r0
            java.lang.String r0 = r0.getAppId()
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r3 = r8._subscriptionManager
            com.onesignal.user.internal.subscriptions.SubscriptionList r3 = r3.getSubscriptions()
            com.onesignal.user.subscriptions.IPushSubscription r3 = r3.getPush()
            java.lang.String r3 = r3.getId()
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L42
            r4 = r5
            goto L43
        L42:
            r4 = r6
        L43:
            if (r4 != 0) goto L52
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L4f
            goto L50
        L4f:
            r5 = r6
        L50:
            if (r5 == 0) goto L57
        L52:
            java.lang.String r4 = "ReceiveReceiptWorkManager: No push subscription or appId!"
            com.onesignal.debug.internal.logging.Logging.debug$default(r4, r2, r1, r2)
        L57:
            com.onesignal.common.AndroidUtils r4 = com.onesignal.common.AndroidUtils.INSTANCE
            int r5 = r8.minDelay
            int r6 = r8.maxDelay
            int r4 = r4.getRandomDelay(r5, r6)
            androidx.work.Data$Builder r5 = new androidx.work.Data$Builder
            r5.<init>()
            java.lang.String r6 = "os_notification_id"
            androidx.work.Data$Builder r5 = r5.putString(r6, r9)
            java.lang.String r6 = "os_app_id"
            androidx.work.Data$Builder r0 = r5.putString(r6, r0)
            java.lang.String r5 = "os_subscription_id"
            androidx.work.Data$Builder r0 = r0.putString(r5, r3)
            androidx.work.Data r0 = r0.build()
            java.lang.String r3 = "Builder()\n              …\n                .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            androidx.work.Constraints r3 = r8.buildConstraints()
            androidx.work.OneTimeWorkRequest$Builder r5 = new androidx.work.OneTimeWorkRequest$Builder
            java.lang.Class<com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker> r6 = com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.class
            r5.<init>(r6)
            androidx.work.WorkRequest$Builder r3 = r5.setConstraints(r3)
            androidx.work.OneTimeWorkRequest$Builder r3 = (androidx.work.OneTimeWorkRequest.Builder) r3
            long r5 = (long) r4
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            androidx.work.WorkRequest$Builder r3 = r3.setInitialDelay(r5, r7)
            androidx.work.OneTimeWorkRequest$Builder r3 = (androidx.work.OneTimeWorkRequest.Builder) r3
            androidx.work.WorkRequest$Builder r0 = r3.setInputData(r0)
            androidx.work.OneTimeWorkRequest$Builder r0 = (androidx.work.OneTimeWorkRequest.Builder) r0
            androidx.work.WorkRequest r0 = r0.build()
            androidx.work.OneTimeWorkRequest r0 = (androidx.work.OneTimeWorkRequest) r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "OSReceiveReceiptController enqueueing send receive receipt work with notificationId: "
            r3.<init>(r5)
            r3.append(r9)
            java.lang.String r5 = " and delay: "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r4 = " seconds"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r3, r2, r1, r2)
            com.onesignal.core.internal.application.IApplicationService r1 = r8._applicationService
            android.content.Context r1 = r1.getAppContext()
            androidx.work.WorkManager r1 = com.onesignal.notifications.internal.common.OSWorkManagerHelper.getInstance(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.String r9 = "_receive_receipt"
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            androidx.work.ExistingWorkPolicy r2 = androidx.work.ExistingWorkPolicy.KEEP
            r1.enqueueUniqueWork(r9, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.enqueueReceiveReceipt(java.lang.String):void");
    }

    private final Constraints buildConstraints() {
        return new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
    }

    /* compiled from: ReceiveReceiptWorkManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager$ReceiveReceiptWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ReceiveReceiptWorker extends CoroutineWorker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReceiveReceiptWorker(Context context, WorkerParameters workerParams) {
            super(context, workerParams);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        @Override // androidx.work.CoroutineWorker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r9) {
            /*
                r8 = this;
                boolean r0 = r9 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1
                if (r0 == 0) goto L14
                r0 = r9
                com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 r0 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 r0 = new com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1
                r0.<init>(r8, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                java.lang.String r3 = "success()"
                r4 = 1
                if (r2 == 0) goto L34
                if (r2 != r4) goto L2c
                kotlin.ResultKt.throwOnFailure(r9)
                goto L8c
            L2c:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L34:
                kotlin.ResultKt.throwOnFailure(r9)
                android.content.Context r9 = r8.getApplicationContext()
                java.lang.String r2 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
                boolean r9 = com.onesignal.OneSignal.initWithContext(r9)
                if (r9 != 0) goto L4e
                androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
                return r9
            L4e:
                androidx.work.Data r9 = r8.getInputData()
                java.lang.String r2 = "os_notification_id"
                java.lang.String r9 = r9.getString(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                androidx.work.Data r2 = r8.getInputData()
                java.lang.String r5 = "os_app_id"
                java.lang.String r2 = r2.getString(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                androidx.work.Data r5 = r8.getInputData()
                java.lang.String r6 = "os_subscription_id"
                java.lang.String r5 = r5.getString(r6)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                com.onesignal.OneSignal r6 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r6 = r6.getServices()
                java.lang.Class<com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor> r7 = com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor.class
                java.lang.Object r6 = r6.getService(r7)
                com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor r6 = (com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor) r6
                r0.label = r4
                java.lang.Object r9 = r6.sendReceiveReceipt(r2, r5, r9, r0)
                if (r9 != r1) goto L8c
                return r1
            L8c:
                androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
