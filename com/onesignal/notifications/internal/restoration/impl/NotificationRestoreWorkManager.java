package com.onesignal.notifications.internal.restoration.impl;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.onesignal.notifications.BuildConfig;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationRestoreWorkManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager;", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "()V", "restored", "", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "shouldDelay", "Companion", "NotificationRestoreWorker", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationRestoreWorkManager implements INotificationRestoreWorkManager {
    private static final String NOTIFICATION_RESTORE_WORKER_IDENTIFIER = NotificationRestoreWorker.class.getCanonicalName();
    private boolean restored;

    @Override // com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager
    public void beginEnqueueingWork(Context context, boolean shouldDelay) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (Boolean.valueOf(this.restored)) {
            if (this.restored) {
                return;
            }
            this.restored = true;
            Unit unit = Unit.INSTANCE;
            OSWorkManagerHelper.getInstance(context).enqueueUniqueWork(NOTIFICATION_RESTORE_WORKER_IDENTIFIER, ExistingWorkPolicy.KEEP, new OneTimeWorkRequest.Builder(NotificationRestoreWorker.class).setInitialDelay(shouldDelay ? 15 : 0, TimeUnit.SECONDS).build());
        }
    }

    /* compiled from: NotificationRestoreWorkManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager$NotificationRestoreWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class NotificationRestoreWorker extends CoroutineWorker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotificationRestoreWorker(Context context, WorkerParameters workerParams) {
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
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r8) {
            /*
                r7 = this;
                boolean r0 = r8 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1
                if (r0 == 0) goto L14
                r0 = r8
                com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 r0 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L19
            L14:
                com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 r0 = new com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1
                r0.<init>(r7, r8)
            L19:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                java.lang.String r3 = "success()"
                r4 = 1
                if (r2 == 0) goto L34
                if (r2 != r4) goto L2c
                kotlin.ResultKt.throwOnFailure(r8)
                goto L79
            L2c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L34:
                kotlin.ResultKt.throwOnFailure(r8)
                android.content.Context r8 = r7.getApplicationContext()
                java.lang.String r2 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
                boolean r2 = com.onesignal.OneSignal.initWithContext(r8)
                if (r2 != 0) goto L4e
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
                return r8
            L4e:
                com.onesignal.notifications.internal.common.NotificationHelper r2 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
                r5 = 2
                r6 = 0
                boolean r8 = com.onesignal.notifications.internal.common.NotificationHelper.areNotificationsEnabled$default(r2, r8, r6, r5, r6)
                if (r8 != 0) goto L62
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.failure()
                java.lang.String r0 = "failure()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                return r8
            L62:
                com.onesignal.OneSignal r8 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r8 = r8.getServices()
                java.lang.Class<com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor> r2 = com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor.class
                java.lang.Object r8 = r8.getService(r2)
                com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor r8 = (com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor) r8
                r0.label = r4
                java.lang.Object r8 = r8.process(r0)
                if (r8 != r1) goto L79
                return r1
            L79:
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
